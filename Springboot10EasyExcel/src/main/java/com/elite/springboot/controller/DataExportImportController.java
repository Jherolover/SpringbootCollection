package com.elite.springboot.controller;

import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.elite.springboot.cache.DataCache;
import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.entity.TableEntity;
import com.elite.springboot.entity.TableEntityVo;
import com.elite.springboot.listener.ColumnListener;
import com.elite.springboot.listener.ExcelListener;
import com.elite.springboot.mapper.ColumnEntityMapper;
import com.elite.springboot.mapper.TableEntityMapper;
import com.elite.springboot.utils.CreateTableHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据导出导入控制类
 */
@RestController
public class DataExportImportController {

    /**
     * 表映射类
     */
    @Resource
    TableEntityMapper tableEntityMapper;
    /**
     * 列映射类
     */
    @Resource
    ColumnEntityMapper columnEntityMapper;

    //临时缓存数据
    @Resource
    DataCache dataCache;

    /**
     * 下载excel模板 
     */
    @GetMapping("/downLoadExcelTemplate")
    public void downLoadExcelTemplate(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("实体类模板", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        //空数据
        List<ColumnEntity> columnEntityList = null;
        EasyExcel.write(response.getOutputStream(), ColumnEntity.class).sheet("创建实体类模板").doWrite(columnEntityList);
    }

    /**
     * 文件上传
     * <p>1. 创建excel对应的实体对象 参照{@link }
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link }
     * <p>3. 直接读即可
     */
    @PostMapping("/uploadExcel")
    public String importData(MultipartFile file, TableEntityVo tableEntityVo) throws IOException {

        //上传Excel解析时报错：Convert excel format exception.You can try specifying the ‘excelType‘ yourself
        //原因是：因为在通过file获取的流类型，在EasyExcel.read读的时候，采用的同一个流，会导致excel类型出错。
        //解决方法：重新创建一个excel流，与获取文件流类型的流区别使用
        String fileName = file.getOriginalFilename();
        //文件类型
        String fileType = fileName.endsWith(".csv")?"CSV":fileName.endsWith(".xls")?"XLS":"XLSX";
        CsvReader csvReader = new CsvReader();
        try {
            //这查询sheetlist的改变了流了类型
            List<ReadSheet> sheets = EasyExcel.read(file.getInputStream()).build().excelExecutor().sheetList();
            for (ReadSheet sheet : sheets) {
                System.out.println(sheet.getSheetNo() + "_" + sheet.getSheetName());
                String sheetName = sheet.getSheetName();

                //表信息
                TableEntity tableEntity = new TableEntity();
                tableEntity.setTableName("table" + sheet.getSheetNo());
                tableEntity.setTableComment(sheetName);
                tableEntity.setDatabaseType(tableEntityVo.getDbType()); //数据库类型
                tableEntity.setDatabaseName(tableEntityVo.getDbName()); //数据库名字
                tableEntity.setTableSchema(tableEntityVo.getSchema()); //schema
                dataCache.tableEntity = tableEntity;//表信息
                dataCache.columnEntityList = new ArrayList<>();
                ExcelReaderSheetBuilder sheet1 = EasyExcel.read(file.getInputStream(), ColumnEntity.class, new ColumnListener(tableEntityMapper, columnEntityMapper, dataCache)).sheet(sheet.getSheetNo());
                sheet1.doRead();
                tableEntity.setTableColumns(dataCache.columnEntityList);
                //生成sql
                String sql = "";//
                if ("oracle".equals(tableEntityVo.getDbType())) {
                    sql = CreateTableHelper.getOracleSqlByConvertEntity(tableEntity);
                } else if ("mssql".equals(tableEntityVo.getDbType())) {
                    sql = CreateTableHelper.getMSSQLSqlByConvertEntity(tableEntity);
                } else if ("mysql".equals(tableEntityVo.getDbType())) {
                    sql = CreateTableHelper.getMysqlSqlByConvertEntity(tableEntity);
                } else {
                    return "数据库类型错误";
                }
                dataCache.sql = dataCache.sql + sql;
                //释放
                dataCache.realseTableColumn();
            }
            String finalSql = dataCache.sql;
            //清除全部的数据
            dataCache.realseAll();
            return finalSql;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
