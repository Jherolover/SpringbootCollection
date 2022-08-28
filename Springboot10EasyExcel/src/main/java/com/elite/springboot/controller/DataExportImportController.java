package com.elite.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.elite.springboot.entity.ColumnEntity;
import com.elite.springboot.listener.ColumnListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 数据导出导入控制类
 */
@RestController
public class DataExportImportController {

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
    public String importData(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ColumnEntity.class, new ColumnListener()).sheet().doRead();
        return "success";
    }


}
