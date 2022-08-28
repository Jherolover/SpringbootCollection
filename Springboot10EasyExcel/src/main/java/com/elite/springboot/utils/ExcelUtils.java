package com.elite.springboot.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.elite.springboot.listener.ColumnListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用easyexcel读取文件的例子
 *
 *
 */
@Slf4j
public class ExcelUtils {


    /**
     * 获取excel文件的内容
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static Sheet readExcelContent(MultipartFile file) throws Exception {

        //上传文件名
        Workbook wb = getWb(file);
        if (wb == null) {
            throw new RuntimeException("文件为空！");
        }
        //返回第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        return sheet;
    }
    //根据Cell类型设置数据
    private static Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case NUMERIC:
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                    break;
                case FORMULA: {
                    cellvalue = cell.getDateCellValue();
                    break;
                }
                case STRING:
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:
                    cellvalue = "";
              }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }
    /**
     * 获取Excel
     *
     * @param mf
     * @return
     */
    private static Workbook getWb(MultipartFile mf) {
        String filepath = mf.getOriginalFilename();
        String ext = filepath.substring(filepath.lastIndexOf("."));
        Workbook wb = null;
        try {
            InputStream is = mf.getInputStream();
            if (".xls".equals(ext)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException", e);
        } catch (IOException e) {
            log.error("IOException", e);
        }
        return wb;
    }
    /**
     * 使用easyexcel读取多个
     * @throws FileNotFoundException
     */
    public void ReadExcel() throws FileNotFoundException {
        String path = "D:\\Users\\lvhb\\Desktop\\test.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        ExcelReader excelReader = EasyExcel.read(inputStream).build();
        //一次性读取多个sheet页
        ReadSheet sheet3 = EasyExcel.readSheet(3).headRowNumber(1).registerReadListener(new ColumnListener()).build();
        ReadSheet sheet4 = EasyExcel.readSheet(4).headRowNumber(1).registerReadListener(new ColumnListener()).build();
        ReadSheet sheet5 = EasyExcel.readSheet(5).headRowNumber(1).registerReadListener(new ColumnListener()).build();
        excelReader.read(sheet3,sheet4,sheet5);
        excelReader.finish();

    }
}
