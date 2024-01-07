package org.example;

import java.io.IOException;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        try {
            ProductFetcher productFetcher = new ProductFetcher();
            List<Product> productList = productFetcher.getAllProducts();

            ExcelWriter excelWriter = new ExcelWriter();
            excelWriter.generateExcelReport(productList, "C:\\Users\\Admin\\Desktop\\Trash\\file.xlsx");

            System.out.println("Excel report generated successfully!");
        } catch (IOException e) {
            System.err.println("Error fetching products or generating Excel report: " + e.getMessage());
            e.printStackTrace();
        }


    }
}