package project.base.poi.sxssf;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * 采用SXSSF导出excel不出现内存溢出，OK
 */
public class Excel_Write2_SXSSF_Util {
    
    //内存中记录条数达到的时候进行flush操作，写入硬盘临时文件，最后一步，进行合并即可；
    private static final int FLUSHNUM = 1000;
    //剩余的内存中的记录条数
    private static final int FLUSHREMAINNUM = 100;
    //默认值为100
    private static final int DEFAULT_WINDOW_SIZE = SXSSFWorkbook.DEFAULT_WINDOW_SIZE;
    private static final String DEFAULTPATH = "d:/temp/";
    private static final String DEFAULTEXCELNAME= "temp";
    private static String EXCELSUFFIX = ".xlsx";//xls
    
    
    public static void main(String[] args) {
        
        //Excel_Write2_SXSSF_Util.write2SXSSF(objectList, path, pathName, dateFormat);
        
    }

    /**
     * 将表格中的数据，写到2007版本的excel文件中
     */
    public static <T> void writeData2SXSSF( List<List<T>> dataList,String path, String excelName,String dateFormat) throws Exception {
        // 参数校验
        if (StringUtils.isBlank(path)) {
            path=DEFAULTPATH;
        }
        if (StringUtils.isBlank(excelName)) {
            excelName=DEFAULTEXCELNAME;
        }
        if (null == dataList || dataList.size() == 0) {
            return;
        }
        
        // 创建一个SXSSFWorkbook，-1代表全部读取完了，最后一次flush写出；默认值为100
        SXSSFWorkbook wb = new SXSSFWorkbook(DEFAULT_WINDOW_SIZE); 
        
        // 创建一个sheet
        Sheet sheet = wb.createSheet();
        //跳过表头行
        for (int rowNum = 1; rowNum < dataList.size(); rowNum++) {
            // 创建一个行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < dataList.get(rowNum-1).size(); cellNum++) {
                // 创建单元格
                Cell cell = row.createCell(cellNum);
                // 单元格地址
                //String address = new CellReference(cell).formatAsString();
                cell.setCellValue(String.valueOf(dataList.get(rowNum-1).get(cellNum)));
            }

            // 1000行向磁盘写一次
            if (rowNum % FLUSHNUM == 0) {
                // retain 100 last rows and
                ((SXSSFSheet) sheet).flushRows(FLUSHREMAINNUM); 
                Thread.sleep(1000);
                // this method flushes all rows
                // ((SXSSFSheet)sheet).flushRows(0);
                System.out.println("正在写入数据....");
            }
        }
        
        //组后进行一次输出
        ((SXSSFSheet)sheet).flushRows(0);
        Thread.sleep(1000);
        System.out.println("写入数据结束....");
        
        FileOutputStream out = new FileOutputStream(path+excelName+EXCELSUFFIX,true);
        // 将临时文件合并，写入最终文件
        wb.write(out);
        
        //短暂休眠
        Thread.sleep(1000);

        out.close();

        wb.dispose();

    }
    
    /**
     * 将表格头，写到2007版本的excel文件中
     */
    public static <T> void writeHeader2SXSSF( List<List<T>> headertList,String path, String excelName,String dateFormat) throws Exception {
        
        // 参数校验
        if (StringUtils.isBlank(path)) {
            path=DEFAULTPATH;
        }
        if (StringUtils.isBlank(excelName)) {
            excelName=DEFAULTEXCELNAME;
        }
        if (null == headertList || headertList.size() == 0) {
            throw new Exception("对不起，标题头不能为空!");
        }
        
        // 创建一个SXSSFWorkbook，-1代表全部读取完了，最后一次flush写出；默认值为100
        SXSSFWorkbook wb = new SXSSFWorkbook(DEFAULT_WINDOW_SIZE); 
        
        // 创建一个sheet
        Sheet sheet = wb.createSheet();
        for (int rowNum = 0; rowNum < headertList.size(); rowNum++) {
            // 创建一个行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < headertList.get(rowNum).size(); cellNum++) {
                // 创建单元格
                Cell cell = row.createCell(cellNum);
                // 单元格地址
                //String address = new CellReference(cell).formatAsString();
                cell.setCellValue(String.valueOf(headertList.get(rowNum).get(cellNum)));
            }
        }
        
        //组后进行一次输出
        ((SXSSFSheet)sheet).flushRows(0);
        Thread.sleep(1000);
        System.out.println("写入数据结束....");
        
        FileOutputStream out = new FileOutputStream(path+excelName+EXCELSUFFIX);
        // 将临时文件合并，写入最终文件
        wb.write(out);
        
        //短暂休眠
        Thread.sleep(1000);
        
        out.close();
        
        wb.dispose();
        
    }

}
