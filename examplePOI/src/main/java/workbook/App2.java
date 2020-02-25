package workbook;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import examplePOI.FileAddressConsts;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App2{
    public static void main(String[] args) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(FileAddressConsts.ADDRESS_CREATE_WORKBOOK));
        XSSFSheet sheet = workbook.getSheetAt(0);
        sheet.copyRows(0, 2, 4, new CellCopyPolicy());
        FileOutputStream out = new FileOutputStream(FileAddressConsts.ADDRESS_CREATE_WORKBOOK);
        workbook.write(out);
        out.close();
    }
}