package project.base.poi.service.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 导出excel接口
 */
public interface ExportExcelService {
   
    /**
     *  headTitle 主标题
     * subTitle 子标题
     * objectList 对象列表
     * path 文件保存路径
     * pathName sheet名
     * response 响应
     *  dateFormat 日期格式
     */
    public void exoprtExcel(String[] headTitle, String[] subTitle, List<?> objectList,
            String path, String pathName,HttpServletResponse response, String dateFormat) throws Exception ;
    
    public void exportCouponExcel() throws Exception ;
    
    public <T> boolean exoprtCouponExcel(List<List<String>> headTitle, List<List<T>> dataList, String path,String excelName)  throws Exception ;

    public void exportOrderCSV(HttpServletResponse response, HttpServletRequest request);
    
    public <T> boolean exportOrderCSV2(List<String> headTitle, List<T> dataList, String path,String excelName) throws Exception;
}
