package workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import examplePOI.FileAddressConsts;

public class WriteIntoExcel {

    public static void main(String... arg) throws FileNotFoundException, IOException {
        writeIntoExcel(FileAddressConsts.ADDRESS_CREATE_WORKBOOK);
    }

    @SuppressWarnings("deprecation")
    public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Birthdays");

        Row row = sheet.createRow(0);

        Cell name = row.createCell(0);
        name.setCellValue("John");

        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);

        birthdate.setCellValue(new Date(110, 10, 10));

        sheet.autoSizeColumn(1);

        book.write(new FileOutputStream(file));
        book.close();
    }

}
