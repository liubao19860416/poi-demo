package project.base.poi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将普通字符串转换为符合CSV格式的字符串  
 */
public class CSVUtils {
    
    public static final String CSV_REGEX = ".*([\"|\\,|\\n|\\r]|(\\r\\n)|(\\n\\r)).*";   
       
    /**  
     * 将普通字符串转换为符合CSV格式的字符串  
     */   
    public static String toCSVString(String str)   
    {   
    	//1.对双引号进行转义处理
        str = str.replaceAll("\"", "\"\"");
        //2.对特殊字符进行转义处理
        Pattern p = Pattern.compile(CSV_REGEX);   
        Matcher m = p.matcher(str);   
        if(m.matches())   
        {   
            str = "\"" + str + "\"";   
        }   
        return str;   
    }   
}