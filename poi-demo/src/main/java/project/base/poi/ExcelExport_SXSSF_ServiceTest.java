package project.base.poi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.base.poi.dao.mapper.CouponMapper;
import project.base.poi.entiy.Coupon;
import project.base.poi.entiy.CouponExample;
import project.base.poi.entiy.CouponExample.Criteria;
import project.base.poi.service.api.ExportExcelService;

public class ExcelExport_SXSSF_ServiceTest extends BaseDAOTest {

    @Autowired
    private ExportExcelService excelService;
    
    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void testExportExcelService() throws Exception {
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

        List<List<String>> headTitle=new ArrayList<List<String>>();
        headTitle.add(headList);
        
        List<List<Object>> dataList=new ArrayList<List<Object>>();
        for (Coupon coupon : couponList) {
            List<Object> list = new ArrayList<Object>();
            list.add(coupon.getId());
            list.add(coupon.getBeginDatetime());
            list.add(coupon.getCode());
            list.add(coupon.getColor1());
            list.add(coupon.getColor2());
            list.add(coupon.getCreatedDatetime());
            list.add(coupon.getDeleted());
            list.add(coupon.getDescription());
            list.add(coupon.getEndDatetime());
            list.add(coupon.getFitToCity());
            list.add(coupon.getFitToEmissionVolume());
            list.add(coupon.getFitToMaxDaysUsed());
            list.add(coupon.getFitToMaxKm());
            
            dataList.add(list);
        }
        
        // excelService.exportCouponExcel();
        
        //boolean result = excelService.exoprtCouponExcel(headTitle, dataList, null, "保养券信息列表");
        
        excelService.exportOrderCSV2(headList, couponList, null, "订单信息列表");

        //Assert.assertTrue(result);
    }

}
