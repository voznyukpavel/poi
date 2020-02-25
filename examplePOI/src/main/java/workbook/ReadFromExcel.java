package workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import examplePOI.FileAddressConsts;

public class ReadFromExcel {
	public static void main(String...arg) throws FileNotFoundException, IOException {
		readFromExcel(FileAddressConsts.ADDRESS_CREATE_WORKBOOK);
	}
	
	public static void readFromExcel(String file) throws IOException{
		XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
		XSSFRow row = myExcelSheet.getRow(0);
        
        if(row.getCell(0).getCellType() == CellType.STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }
        
        if(row.getCell(1).getCellType() == CellType.NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }
        
        myExcelBook.close();
        
    }
}
