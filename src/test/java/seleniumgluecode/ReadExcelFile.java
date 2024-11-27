package seleniumgluecode;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {

    public ReadExcelFile() {
        // TODO Auto-generated constructor stub
    }

    public String[][] readExcel(String filepath, String sheetName) throws IOException {

        File file = new File(filepath);
        String celValue[][];
        celValue = new String[10][50];

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = newSheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.println(row.getCell(j).getStringCellValue() + "||");
                celValue[i][j] = row.getCell(j).getStringCellValue();
            }
        }

        return  celValue;
    }


    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();



    }
}