package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

    public void generateExcelReport(List<Product> productList, String excelFilePath) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("ProductReport");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Product ID");
            headerRow.createCell(1).setCellValue("Product Title");
            headerRow.createCell(2).setCellValue("Product Price");
            headerRow.createCell(3).setCellValue("Product Description");

            for (Product product : productList) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(product.getId());
                dataRow.createCell(1).setCellValue(product.getTitle());
                dataRow.createCell(2).setCellValue(product.getPrice());
                dataRow.createCell(3).setCellValue(product.getDescription());
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(fileOutputStream);
            }
        }
    }
}
