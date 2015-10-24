package project.base.poi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meidusa.toolkit.common.util.StringUtil;

/**
 * Excel工具类
 */
public final class ExcelUtil {
    /**
     * 读取Excel异常
     */
    public static final String READ_EXCEL_ERR_INFO = "读取Excel异常";
    /**
     * 读取Excel异常编码
     */
    public static final int READ_EXCEL_ERR_CODE = 30100004;

    /**
     * 失败代码
     */
    public static final String FAIL_RESULT = "0";

    /**
     * 成功代码
     */
    public static final String SUCCESS_RESULT = "1";

    /**
     * 空值
     */
    private static final String IS_NULL = "为空值";

    /**
     * 日志组件
     */
    private static Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 读写Excel异常信息
     */
    private static String exceptionMsg = "读写Excel异常：";

    /**
     * 构造方法
     */
    private ExcelUtil() {

    }

    /**
     *  功能描述:判断excle文件文件名是否正确
     */
    public static boolean isExcel(String filePath) {
        boolean flag = false;
        String xlsReg = "^.+\\.(?i)(xls)$";
        String xlsxReg = "^.+\\.(?i)(xlsx)$";
        if (filePath.matches(xlsReg) || filePath.matches(xlsxReg)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 功能描述:检查文件是否存在  
     */
    public static boolean isExist(String filePath) {
        if (StringUtil.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述:依据内容判断是否为excel2003及以下
     */
    public static boolean isExcel2003(FileInputStream excelFileInputStream) {
        try {
            BufferedInputStream bis = new BufferedInputStream(excelFileInputStream);
            if (POIFSFileSystem.hasPOIFSHeader(bis)) {
                return true;
            }
        } catch (IOException e) {
            log.error(exceptionMsg, e);
            return false;
        }
        return false;
    }

    /**
     * 功能描述:依据内容判断是否为excel2007及以上 
     */
    public static boolean isExcel2007(FileInputStream excelFileInputStream) {
        try {
            BufferedInputStream bis = new BufferedInputStream(excelFileInputStream);
            if (POIXMLDocument.hasOOXMLHeader(bis)) {
                return true;
            }
        } catch (IOException e) {
            log.error(exceptionMsg, e);
            return false;
        }
        return false;
    }

    /**
     * 校验excel中的值，判断是否有空值
     */
    public static String[] checkExcelValue(int rowCount, Sheet sheet) {
        String[] results = new String[] { SUCCESS_RESULT, SUCCESS_RESULT };
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (null == row) {
                results[0] = FAIL_RESULT;
                results[1] = exceptionMsg;
                break;
            }
            int rowNum = i + 1;

            for (int c = 0; c < row.getPhysicalNumberOfCells(); c++) {
                String value = getRowValue(row, c);
                if (StringUtil.isEmpty(value)) {
                    results[0] = FAIL_RESULT;
                    results[1] = getErrorMsgForExcel(rowNum, c, value, IS_NULL);
                    break;
                }
            }
            if (results[0].equals(FAIL_RESULT)) {
                break;
            }
        }
        return results;
    }

    /**
     * 返回excel报错结果
     */
    public static String getErrorMsgForExcel(int row, int column, String value,String msg) {
        StringBuffer stringBuffer = new StringBuffer();
        if (row > 0) {
            stringBuffer.append("第" + row + "行,");
        }
        if (column >= 0) {
            stringBuffer.append("第" + (column + 1) + "列,");
        }
        if (!StringUtil.isEmpty(value)) {
            stringBuffer.append("内容:" + value + ",");
        }
        if (!StringUtil.isEmpty(msg)) {
            stringBuffer.append(msg);
        }
        return stringBuffer.toString();
    }

    /**
     * 获取某单元的值
     */
    public static String getRowValue(Row row, int columnNum) {
        Cell cell = row.getCell(columnNum);
        String cellValue = "";
        if (null != cell) {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
            /**
             * 数字， XSSFCell可以达到相同的效果
             * case XSSFCell.Cell.CELL_TYPE_NUMERIC:
             */
            case XSSFCell.CELL_TYPE_NUMERIC:
                double d = cell.getNumericCellValue();
                cellValue = d + "";
                if (cellValue.endsWith(".0")) {
                    cellValue = "" + (int) Double.parseDouble(cellValue);
                }
                break;
            case XSSFCell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case XSSFCell.CELL_TYPE_FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case XSSFCell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case XSSFCell.CELL_TYPE_ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
            }

        }
        return cellValue;
    }

    /**
     * 获取excel对象
     */
    public static Workbook getExcelFileInputStream(FileInputStream excelFileInputStream) throws Exception {
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(excelFileInputStream);
        } catch (InvalidFormatException e) {
            log.error(exceptionMsg, e);
            throw new Exception("", e);
        } catch (IOException e) {
            log.error(exceptionMsg, e);
            throw new Exception("", e);
        } finally {
            if (excelFileInputStream != null) {
                try {
                    excelFileInputStream.close();
                } catch (IOException e) {
                    log.error(exceptionMsg, e);
                    throw new Exception("", e);
                }
            }
        }
        return wb;
    }
}
