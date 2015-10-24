package project.base.poi.hssf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * poi测试导出excel文件，数据量大出现内存溢出,暂时不用，有乱码
 */
public class Excel_Write2_HSSF {

    public static void main(String[] args) throws IOException {
        // 创建文件输出流
        FileOutputStream out = new FileOutputStream("d:/temp/excel.xls",true);
        // 创建一个工作簿
        Workbook wb = new HSSFWorkbook();
        for (int j = 0; j < 1; j++) {
            // 创建1个sheet
            Sheet s = wb.createSheet();
            // 指定sheet的名称
            wb.setSheetName(j, "sheet" + j);
            // 创建行,.xls一个sheet中的行数最大65535
            for (int rownum = 0; rownum < 65536; rownum++) {
                // 创建一行
                Row r = s.createRow(rownum);
                for (int cellnum = 0; cellnum < 10; cellnum++) {
                    // 在行里边创建单元格,一行创建10个单元格
                    Cell c = r.createCell(cellnum);
                    // 向单元格写入数据
                    c.setCellValue(cellnum);
                }
            }
        }
        System.out.println("int..............");
        wb.write(out);// 输出文件内容
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

}
