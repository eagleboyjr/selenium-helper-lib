package daolibrary;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public interface ExcelDao {


    default String[][] readExcelFile(String path, String sheet) throws IOException{
        XSSFWorkbook workBook;
        XSSFSheet workSheet;

        try(FileInputStream excelFile = new FileInputStream(path)){
            //Open Excel File
            workBook = new XSSFWorkbook(excelFile);
            //Access Excel Data Sheet
            workSheet = workBook.getSheet(sheet);

           return getTestData(workBook, workSheet);

        }catch(FileNotFoundException e){
            throw(e);
        }
    }

    default String[][] getTestData(XSSFWorkbook workBook, XSSFSheet workSheet) throws IOException {
        String[][] data = null;

        DataFormatter dataFormatter = new DataFormatter();

        //Retrieves the last row number on the sheet
        int rowCount = workSheet.getLastRowNum();

        //Retrieves last cell of the row to
        int columnCount = workSheet.getRow(0).getLastCellNum();

        data = new String[rowCount][columnCount];

        try {
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = workSheet.getRow(i + 1).getCell(j);
                    data[i][j] = dataFormatter.formatCellValue(cell);
                    // System.out.println(data[i][j]);
                }
            }
        }catch (Exception e){
            System.out.println(e);
            throw(e);
        }
        workBook.close();

        //System.out.println(Arrays.deepToString(data));


        return data;
    }

    default void writeToExcelFile(){

    }

}
