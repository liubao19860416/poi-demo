package project.base.poi.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.base.poi.dao.mapper.CouponMapper;
import project.base.poi.entiy.Coupon;
import project.base.poi.entiy.CouponExample;
import project.base.poi.entiy.CouponExample.Criteria;
import project.base.poi.service.api.ExportExcelService;
import project.base.poi.sxssf.Excel_Write2_SXSSF_Util;

@Service
public class ExportExcelServiceImpl implements ExportExcelService {

    private static Logger logger = LoggerFactory.getLogger(ExportExcelServiceImpl.class);
    
    //内存中记录条数达到的时候进行flush操作，写入硬盘临时文件，最后一步，进行合并即可；
    private static final int FLUSHNUM = 1000;
    //剩余的内存中的记录条数
    private static final int FLUSHREMAINNUM = 100;
    //默认值为100
    private static final int DEFAULT_WINDOW_SIZE = SXSSFWorkbook.DEFAULT_WINDOW_SIZE;
    private static final String DEFAULTPATH = "d:/temp/";
    private static final String DEFAULTEXCELNAME= "temp";
    private static String EXCELSUFFIX = ".xlsx";//xls

    private static final String DEALER_LIST = "dealerList";
    
    @Autowired
    private CouponMapper couponMapper;
    
    /**
     * 根据组合条件Excel文件格式导出订单列表
     */
    public void exportCouponExcel() throws Exception {
        //拼装excel的表头信息和表体数据集合对象
        List<List<String>> headertList=new ArrayList<List<String>>();
        List<List<Object>> dataList=new ArrayList<List<Object>>();
        
        //拼装excel的数据信息
        CouponExample example=new CouponExample();
        Criteria criteria = example.createCriteria();
        criteria.andActivedIsNotNull();
        List<Coupon> couponList = couponMapper.selectByExample(example);
        
        //反射使用
        Field[] fields = Coupon.class.getDeclaredFields();
        
        //表头list
        List<String> list1=new ArrayList<String>();
        for (Coupon coupon : couponList) {
            //表体数据list
            List<Object> list2=new ArrayList<Object>();
            //拼装参数
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                //过滤属性
                if ("serialVersionUID".equalsIgnoreCase(name)) {
                    continue;
                }
                if (PropertyUtils.isReadable(coupon, name)) {
                    if(list1.size()!=fields.length-1){
                        //封装表格头，封装一次就行了
                        list1.add(name);
                    }
                    //封装表格体数据
                    Object value = PropertyUtils.getSimpleProperty(coupon, name);
                    if (value != null) {
                        list2.add(value);
                    }
                }
            }
            //添加到集合中，循环遍历添加
            dataList.add(list2);
        }
        
        //添加表头到集合中，添加1次即可
        headertList.add(list1);
        
        //设置表格名称
        String excelName = new String(("excel文件名").getBytes(), "utf-8");
        
        //导出表格头
        //Excel_Write2_SXSSF_Util.writeHeader2SXSSF(headertList, null, excelName, null);
        
        //导出表格体数据
        Excel_Write2_SXSSF_Util.writeData2SXSSF(dataList, null, excelName, null);
    }

    
    /**
     * 根据组合条件以Excel文件格式导出订单列表
     */
    @Override
    public void exportOrderCSV(HttpServletResponse response, HttpServletRequest request) {
        
        Map<String, Object> params = transRequestToMap(request);
        
        if(params==null){
            return ;
        }
        try {
            List<String> headList = new ArrayList<String>();
            headList.add("订单号");
            headList.add("保养时间");
            headList.add("经销商");
            headList.add("客户姓名");
            headList.add("手机号");
            headList.add("订单价格");
            headList.add("下单时间");
            headList.add("最后更新时间");
            headList.add("订单状态");
            headList.add("设备号");
            headList.add("会员号");
            headList.add("车牌号");
            headList.add("激活通道");

            // 根据组合条件查询订单列表
            //拼装excel的数据信息
            CouponExample example=new CouponExample();
            Criteria criteria = example.createCriteria();
            criteria.andActivedIsNotNull();
            List<Coupon> couponList = couponMapper.selectByExample(example);
            
            // 添加筛选条件
            if (couponList.size() > 100000) {
                PrintWriter out = response.getWriter();
                out.print("<script>alert('导出报表数据过多！请添加筛选条件！');</script>");
            }

            // 创建Excel工作簿
            Workbook wb = new HSSFWorkbook();
            // 创建第一个sheet（页），并命名
            Sheet sheet = wb.createSheet("订单报表");
            // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
            sheet.setColumnWidth((short) 0, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 1, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 2, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 3, (short) (35.7 * 100));
            sheet.setColumnWidth((short) 4, (short) (35.7 * 250));
            sheet.setColumnWidth((short) 5, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 6, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 7, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 8, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 9, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 10, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 11, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 12, (short) (35.7 * 150));
            // 创建第一行，从0开始
            Row row = sheet.createRow((short) 0);
            // 创建两种单元格格式
            CellStyle cs = wb.createCellStyle();
            CellStyle cs2 = wb.createCellStyle();
            // 创建两种字体
            Font f = wb.createFont();
            Font f2 = wb.createFont();
            // 创建表头字体样式
            f.setFontHeightInPoints((short) 10);
            f.setColor(IndexedColors.RED.getIndex());
            f.setBoldweight(Font.BOLDWEIGHT_BOLD);
            // 创建数据字体样式
            f2.setFontHeightInPoints((short) 10);
            f2.setColor(IndexedColors.BLACK.getIndex());
            f2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
            // 设置表头单元格的样式
            cs.setFont(f);
            cs.setBorderLeft(CellStyle.BORDER_THIN);
            cs.setBorderRight(CellStyle.BORDER_THIN);
            cs.setBorderTop(CellStyle.BORDER_THIN);
            cs.setBorderBottom(CellStyle.BORDER_THIN);

            // 设置数据单元格的样式
            cs2.setFont(f2);
            // 设置单元格为文本格式
            cs2.setDataFormat((short) Cell.CELL_TYPE_STRING);
            cs2.setBorderLeft(CellStyle.BORDER_THIN);
            cs2.setBorderRight(CellStyle.BORDER_THIN);
            cs2.setBorderTop(CellStyle.BORDER_THIN);
            cs2.setBorderBottom(CellStyle.BORDER_THIN);

            // 创建列（每行里的单元格）
            Cell cell = null;
            for (int i = 0; i < headList.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(headList.get(i));
                cell.setCellStyle(cs);
            }

            if (couponList != null && couponList.size() > 0) {
                for (int i = 0; i < couponList.size(); i++) {
                    Coupon coupon = couponList.get(i);
                    // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的;创建一行，在页sheet上
                    row = sheet.createRow(i + 1);
                    // 在row行上创建一个方格
                    cell = row.createCell(0);
                    cell.setCellValue(coupon.getCode());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(1);
                    cell.setCellValue(coupon.getColor1());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(2);
                    cell.setCellValue(coupon.getColor2());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(3);
                    cell.setCellValue(coupon.getDescription());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(4);
                    cell.setCellValue(coupon.getFitToCity());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(5);
                    cell.setCellValue(coupon.getFitToEmissionVolume());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(6);
                    cell.setCellValue(coupon.getFitToVehicleScope());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(7);
                    cell.setCellValue(coupon.getName());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(8);
                    cell.setCellValue(coupon.getRuleBrief());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(9);
                    cell.setCellValue(coupon.getActived());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(10);
                    cell.setCellValue(coupon.getBeginDatetime());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(11);
                    cell.setCellValue(coupon.getCreatedDatetime());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(12);
                    cell.setCellValue(coupon.getDeleted());
                    cell.setCellStyle(cs2);
                    //^^^^^^
                }
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                //写入内存中
                wb.write(os);
            } catch (IOException e) {
                logger.error(e.toString());
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String(("订单管理报表.xls").getBytes(), "ISO-8859-1"));
            
            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int len=-1;
                while (-1 != (len = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, len);
                }
            } catch (final IOException e) {
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }
    
    @Override
    public <T> boolean exportOrderCSV2(List<String> headTitle, List<T> dataList, String path,String excelName) throws Exception {
        // 参数校验
        if (StringUtils.isBlank(path)) {
            path=DEFAULTPATH;
        }
        if (StringUtils.isBlank(excelName)) {
            excelName=DEFAULTEXCELNAME;
        }
        if (null == dataList || dataList.size() == 0) {
            return false;
        }
        
        if (null == headTitle || headTitle.size() == 0) {
            throw new Exception("对不起，标题头不能为空!");
        }
        try {
            List<String> headList = new ArrayList<String>();
            headList.add("订单号");
            headList.add("保养时间");
            headList.add("经销商");
            headList.add("客户姓名");
            headList.add("手机号");
            headList.add("订单价格");
            headList.add("下单时间");
            headList.add("最后更新时间");
            headList.add("订单状态");
            headList.add("设备号");
            headList.add("会员号");
            headList.add("车牌号");
            headList.add("激活通道");
            
            // 根据组合条件查询订单列表
            //拼装excel的数据信息
            CouponExample example=new CouponExample();
            Criteria criteria = example.createCriteria();
            criteria.andActivedIsNotNull();
            List<Coupon> couponList = couponMapper.selectByExample(example);
            
            // 创建Excel工作簿
            Workbook wb = new HSSFWorkbook();
            // 创建第一个sheet（页），并命名
            Sheet sheet = wb.createSheet("订单报表");
            // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
            sheet.setColumnWidth((short) 0, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 1, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 2, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 3, (short) (35.7 * 100));
            sheet.setColumnWidth((short) 4, (short) (35.7 * 250));
            sheet.setColumnWidth((short) 5, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 6, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 7, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 8, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 9, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 10, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 11, (short) (35.7 * 150));
            sheet.setColumnWidth((short) 12, (short) (35.7 * 150));
            // 创建第一行，从0开始
            Row row = sheet.createRow((short) 0);
            // 创建两种单元格格式
            CellStyle cs = wb.createCellStyle();
            CellStyle cs2 = wb.createCellStyle();
            // 创建两种字体
            Font f = wb.createFont();
            Font f2 = wb.createFont();
            // 创建表头字体样式
            f.setFontHeightInPoints((short) 10);
            f.setColor(IndexedColors.RED.getIndex());
            f.setBoldweight(Font.BOLDWEIGHT_BOLD);
            // 创建数据字体样式
            f2.setFontHeightInPoints((short) 10);
            f2.setColor(IndexedColors.BLACK.getIndex());
            f2.setBoldweight(Font.BOLDWEIGHT_NORMAL);
            // 设置表头单元格的样式
            cs.setFont(f);
            cs.setBorderLeft(CellStyle.BORDER_THIN);
            cs.setBorderRight(CellStyle.BORDER_THIN);
            cs.setBorderTop(CellStyle.BORDER_THIN);
            cs.setBorderBottom(CellStyle.BORDER_THIN);
            
            // 设置数据单元格的样式
            cs2.setFont(f2);
            // 设置单元格为文本格式
            cs2.setDataFormat((short) Cell.CELL_TYPE_STRING);
            cs2.setBorderLeft(CellStyle.BORDER_THIN);
            cs2.setBorderRight(CellStyle.BORDER_THIN);
            cs2.setBorderTop(CellStyle.BORDER_THIN);
            cs2.setBorderBottom(CellStyle.BORDER_THIN);
            
            // 创建列（每行里的单元格）
            Cell cell = null;
            for (int i = 0; i < headList.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(headList.get(i));
                cell.setCellStyle(cs);
            }
            
            if (couponList != null && couponList.size() > 0) {
                for (int i = 0; i < couponList.size(); i++) {
                    Coupon coupon = couponList.get(i);
                    // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的;创建一行，在页sheet上
                    row = sheet.createRow(i + 1);
                    // 在row行上创建一个方格
                    cell = row.createCell(0);
                    cell.setCellValue(coupon.getCode());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(1);
                    cell.setCellValue(coupon.getColor1());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(2);
                    cell.setCellValue(coupon.getColor2());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(3);
                    cell.setCellValue(coupon.getDescription());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(4);
                    cell.setCellValue(coupon.getFitToCity());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(5);
                    cell.setCellValue(coupon.getFitToEmissionVolume());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(6);
                    cell.setCellValue(coupon.getFitToVehicleScope());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(7);
                    cell.setCellValue(coupon.getName());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(8);
                    cell.setCellValue(coupon.getRuleBrief());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(9);
                    cell.setCellValue(coupon.getActived());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(10);
                    cell.setCellValue(coupon.getBeginDatetime());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(11);
                    cell.setCellValue(coupon.getCreatedDatetime());
                    cell.setCellStyle(cs2);
                    cell = row.createCell(12);
                    cell.setCellValue(coupon.getDeleted());
                    cell.setCellStyle(cs2);
                }
            }
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                //写入内存中
                wb.write(os);
            } catch (IOException e) {
                logger.error(e.toString());
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            
            //修改类型
            EXCELSUFFIX = ".xls";//xlsx
            FileOutputStream out = new FileOutputStream(path+excelName+EXCELSUFFIX);
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int len=-1;
                while (-1 != (len = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, len);
                }
            } catch (final IOException e) {
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public void exoprtExcel(String[] headTitle, String[] subTitle,
            List<?> objectList, String path, String pathName,HttpServletResponse response, String dateFormat)  throws Exception {

    }
    
    @Override
    public <T> boolean exoprtCouponExcel(List<List<String>> headTitle, List<List<T>> dataList, String path,String excelName)  throws Exception {
        // 参数校验
        if (StringUtils.isBlank(path)) {
            path=DEFAULTPATH;
        }
        if (StringUtils.isBlank(excelName)) {
            excelName=DEFAULTEXCELNAME;
        }
        if (null == dataList || dataList.size() == 0) {
            return false;
        }
        
        if (null == headTitle || headTitle.size() == 0) {
            throw new Exception("对不起，标题头不能为空!");
        }
        
        // 创建一个SXSSFWorkbook，-1代表全部读取完了，最后一次flush写出；默认值为100
        SXSSFWorkbook wb = new SXSSFWorkbook(DEFAULT_WINDOW_SIZE); 
        
        // 创建一个sheet，可以创建多个sheet，且指定其名称
        Sheet sheet = wb.createSheet("sheet名称");
        //Sheet sheet = wb.createSheet();
        // 创建一个行
        Row row = sheet.createRow(0);
       /* //首先设置表头
        for (int cellNum = 0; cellNum < headTitle.get(0).size(); cellNum++) {
            // 创建单元格
            Cell cell = row.createCell(cellNum);
            // 单元格地址
            String address = new CellReference(cell).formatAsString();
            cell.setCellValue(String.valueOf(headTitle.get(0).get(cellNum)));
        }*/
        
        /*//设置表内容数据
         for (int rowNum = 1; rowNum < dataList.size(); rowNum++) {
            // 创建一个行，从1开始
            row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < dataList.get(rowNum-1).size(); cellNum++) {
                // 创建单元格
                Cell cell = row.createCell(cellNum);
                // 单元格地址
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(String.valueOf(dataList.get(rowNum-1).get(cellNum)));
            }
            // 1000行向磁盘写一次
            if (rowNum % FLUSHNUM == 0) {
                ((SXSSFSheet) sheet).flushRows(FLUSHREMAINNUM); 
                Thread.sleep(1000);
                System.out.println("正在写入数据....");
            }
        }*/
         
         //合并
        for (int rowNum = 0; rowNum < dataList.size(); rowNum++) {
            // 创建一个行
            row = sheet.createRow(rowNum);
            //首先设置表头
            for (int cellNum = 0; cellNum < dataList.get(rowNum).size(); cellNum++) {
                // 创建单元格
                Cell cell = row.createCell(cellNum);
                // 单元格地址
                String address = new CellReference(cell).formatAsString();
                if (rowNum == 0) {
                    cell.setCellValue(String.valueOf(headTitle.get(rowNum).get(cellNum)));
                } else {
                    cell.setCellValue(String.valueOf(dataList.get(rowNum).get(cellNum)));
                }
            }
            // 1000行向磁盘写一次
            if (rowNum % FLUSHNUM == 0) {
                ((SXSSFSheet) sheet).flushRows(FLUSHREMAINNUM); 
                Thread.sleep(1000);
                System.out.println("正在写入数据....");
            }
        }
        
        //组后进行一次输出
        // this method flushes all rows
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
        
        return true;
    }
    
    /**
     * 将request中的key和value拼装成map集合返回
     */
    private Map<String, Object> transRequestToMap(HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 方式1：一个一个的获取拼装参数即可
        //if(!StringUtils.isEmpty(request.getParameter("tabName"))){
        //    params.put("tabName", request.getParameter("tabName").toString());
        //}
        //方式2：反射获取
        Map<?, ?> parameterMap = request.getParameterMap();
        Enumeration<?> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = (String)parameterNames.nextElement();
            Object value = parameterMap.get(key)==null?"":parameterMap.get(key);
            if(value instanceof String){
                value=(String)value;
            }
            resultMap.put(key, value);
        }
        return resultMap;
    }
}
