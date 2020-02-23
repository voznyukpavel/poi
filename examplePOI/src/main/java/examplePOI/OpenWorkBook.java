package examplePOI;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class OpenWorkBook {
   public static void main(String args[])throws Exception { 
      File file = new File(FileAddressConsts.ADDRESS);
      FileInputStream fIP = new FileInputStream(file);
      
      //Get the workbook instance for XLSX file 
      XSSFWorkbook workbook = new XSSFWorkbook(fIP);
      
      if(file.isFile() && file.exists()) {
         System.out.println("openworkbook.xlsx file open successfully.");
      } else {
         System.out.println("Error to open openworkbook.xlsx file.");
      }
   }
}