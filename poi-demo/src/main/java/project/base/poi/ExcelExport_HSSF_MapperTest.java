package project.base.poi;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.base.poi.dao.mapper.CouponMapper;
import project.base.poi.entiy.Coupon;
import project.base.poi.entiy.CouponExample;
import project.base.poi.entiy.CouponExample.Criteria;
import project.base.poi.util.ExportExcel;
/**
 * 测试有问题，暂时不用
 * @author Liubao
 * @2014年12月7日
 *
 */
public class ExcelExport_HSSF_MapperTest extends BaseDAOTest {

    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void testExportExcel() throws Exception {
        String fileName = new String(("导出excel文件名").getBytes(), "utf-8");

        // 拼装excel的表头信息
        List<String> headList = new ArrayList<String>();
        Coupon coupon = new Coupon();
        Field[] fields = coupon.getClass().getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            headList.add(name);
            // 通过注解获取其属性的名称
        }

        // 拼装excel的数据信息
        CouponExample example = new CouponExample();
        Criteria criteria = example.createCriteria();
        criteria.andActivedIsNotNull();
        List<Coupon> dataList = couponMapper.selectByExample(example);

        boolean result = ExportExcel.excelExportTest(fileName, headList,
                dataList);

        Assert.assertTrue(result);
    }
}
