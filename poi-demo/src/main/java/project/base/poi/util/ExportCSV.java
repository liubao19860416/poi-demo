package project.base.poi.util;

import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供CSV各式文件导出功能 通过ArrayList数据集内容导出
 */
public class ExportCSV {

    // 日志对象
    private static Logger logger = LoggerFactory.getLogger(ExportCSV.class);
    private static long singleRecordCount = 1000l;
    private static String charset = "UTF-8";
    private static String headSeqName = "行号";
    private static String extName = ".csv";

    /**
     * 通过dataList中的list对象内容导出CSV文件 使用说明：
     * 1.dataList中的数据记录由调用方法进行组装处理，并完成数据记录的相关格式转换处理。
     * 2.headList中标题的顺序需与dataList中的ArrayList的数据对象顺序一致 4.需由调用方法进行导出记录数的控制
     * 5.通过singleRecordCount配置参数控制单次写到输出流的最大记录数，方法会根据实际数据记录数循环分次输出
     */
    public static void csvExport(HttpServletResponse response, String reptName,
            List<?> headList, List<?> dataList, HttpServletRequest request) throws Exception {
        // 1.参数校验
        if (StringUtils.isNotBlank(reptName)) {
            throw new Exception("对不起，导出文件名不能为空!");
        }
        if (null == headList || headList.size() == 0) {
            throw new Exception("对不起，标题内容不能为空!");
        }

        // 2.处理文件信息，清空response缓存中的信息
        response.reset();
        
        response.setContentType("application/octet-stream; charset=" + charset);
        String fileName = new String((reptName + extName).getBytes(), "utf-8");
       
        //这是校验用户浏览器信息的部分，可以有效的解决乱码问题
        final String userAgent = request.getHeader("USER-AGENT");
        if (userAgent.contains("MSIE") || userAgent.contains("rv:11.0")) {
            // IE浏览器 (IE 11的userAgent已更改，需根据rv:11.0来判别)
            fileName = URLEncoder.encode(fileName, "UTF8");
        } else if (userAgent.contains("Mozilla")) {
            // google,火狐浏览器
            fileName = new String(fileName.getBytes(), "ISO8859-1");
        } else {
            // 其他浏览器
            fileName = URLEncoder.encode(fileName, "UTF8");
        }
        // 这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
        response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
        response.setHeader("Content-type", "application-download");

        // 3.导出CSV文件内容
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            // 生成CSV文件标题
            setHead(out, headList);
            // 生成CSV文件记录数据
            setBody(out, dataList);
            // 导出CSV文件内容
            out.flush();
        } finally {// 关闭输出流
            if (out != null) {
                out.close();
                out = null;
            }
        }
    }

    /**
     *  根据headList中的数据顺序生成CSV标题内容，以逗号分隔。
     */
    private static void setHead(OutputStream out, List<?> headList) throws Exception {
        String head = null;
        if (null == headList || headList.size() == 0) {
            throw new Exception("对不起，标题内容不能为空!");
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append(headSeqName);
            for (int i = 0; i < headList.size(); i++) {
                sb.append(",");
                // 对数据内容进行转换处理
                sb.append(CSVUtils.toCSVString((String) headList.get(i)));
            }
            sb.append("\n");
            head = sb.toString();

            if (StringUtils.isNotBlank(head)) {
                throw new Exception("对不起，标题内容不能为空!");
            } else {
                // 将内存内容输出,清理内存
                logger.info(ExportCSV.class.getName() + ">>>head=" + head);
                out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                out.write(head.getBytes());
                out.flush();
            }
        }

    }

    /**
     * 通过ArrayList数据集，生成CSV文件记录数据
     */
    private static void setBody(OutputStream out, List<?> dataList) throws Exception {
        // 1.参数校验
        if (null == dataList || dataList.size() == 0) {
            return;
        }
        // 2.将dataList的数据内容写到输出流
        Object dataForm = null;
        int recordCount = 1;
        StringBuffer sb = new StringBuffer();
        String str = null;
        for (int i = 0; i < dataList.size(); i++) {
            dataForm = dataList.get(i);
            // 调用者需重写相应form的toCsvString方法
            // 按照显示顺序将form的attribute属性以英文逗号方式连接，且行末用"\n"进行换行
            // 最后注意每个attribute都需要调用CsvUtils.toCsvString方法进行格式转换
            sb.append(recordCount);
            sb.append(",");
            sb.append(dataForm.toString());
            sb.append("\n");

            // 根据参数singleRecordCount的配置，没指定记录数输出一次并清空StringBuffer
            if (recordCount % singleRecordCount == 0|| recordCount == dataList.size()) {
                str = sb.toString();
                if (!StringUtils.isNotBlank(str)) {
                    // 将内存内容输出,清理内存
                    logger.info(ExportCSV.class.getName() + ">>>recordCount="+ recordCount + " str=" + str);
                    out.write(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF });
                    out.write(str.getBytes());
                    out.flush();
                    sb.setLength(0);
                }
            }
            recordCount++;
        }
    }

}
