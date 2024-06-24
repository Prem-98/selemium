import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
    public static void main(String[] args) {


//        Workbook workbook = new XSSFWorkbook();
//
//        // Create a Sheet object.
//        Sheet sheet = workbook.createSheet("My Sheet");
//
//        // Create a Row object.
//        Row row = sheet.createRow(0);
//
//        // Create a Cell object.
//        Cell cell = row.createCell(0);
//
//        // Set the value of the Cell object.
//        cell.setCellValue("Hello, World!");
//
//        // Save the Workbook object to an XLS file.
//        workbook.write(new FileOutputStream("C:\\My Folder\\my_file.xls"));
//        workbook.close();
//
//        ArrayList<String> names = new ArrayList<>();
//        FileInputStream fis = new FileInputStream("C:\\My Folder\\my_file.xls");
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0);
//        System.out.println(sheet.getRow(0).getCell(0));

//        for (Row row : sheet) {
//            for (Cell cell : row) {
//                String header=cell.getStringCellValue();
//                names.add(header);
////                System.out.println(cell.getStringCellValue());
//            }
//        }
//        System.out.println(names);
//        workbook.close();
//        fis.close();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // Add a value for the key "key1"
        map.put("key1", new ArrayList<>());
        map.get("key1").add("value1");

        // Add another value for the key "key1"
        map.get("key1").add("value2");

        // Print the values for the key "key1"
        System.out.println(map.get("key1").get(1));
    }}
