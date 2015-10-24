package project.base.poi.hssf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 传统方式采用HSSFWorkbook读取xls文件内容，数据量大时报内存溢出
 */
public class ReadExcelHSSF {
    
    public static void main(String[] args) throws IOException {
        ReadExcelHSSF xlsMain = new ReadExcelHSSF();
        xlsMain.readXls();
    }

    /**
     * 读取xls文件内容
     */
    private void readXls() throws IOException {
        // 文件输入流
        InputStream is = new FileInputStream("d:/temp/excel.xls");
        // 创建hssf的workbook，将文件流传入workbook
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // 解析workbook的内容，getNumberOfSheets()得到所有sheet的个数
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            // 得到workbook某个 的sheet，numSheet是sheet 的序号，序号从0开始
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                // 读取每一行数据 ,rowNum指定行下标 从1开始
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                System.out.println("hssfRow" + hssfRow.getRowNum());
                // 读取单元格内容
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    // 读取一行中某个单元格内容，cellNum指定单元格的下标，从0开始
                    HSSFCell cell = hssfRow.getCell(cellNum);
                    if (cell == null) {
                        continue;
                    }
                    System.out.print(cell.getStringCellValue() +",");
                }

            }

        }

        // return list;

    }

}
