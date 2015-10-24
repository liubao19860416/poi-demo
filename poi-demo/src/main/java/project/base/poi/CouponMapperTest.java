package project.base.poi;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import project.base.poi.dao.mapper.CouponMapper;
import project.base.poi.entiy.Coupon;
import project.base.poi.entiy.CouponExample;
import project.base.poi.entiy.CouponExample.Criteria;

public class CouponMapperTest extends BaseDAOTest {

    @Autowired
    private CouponMapper couponMapper;

    @Test
    public void testSelectCoupon() throws Exception {
        Long id=9l;
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        Assert.assertNotNull(coupon);
    }
    
    @Test
    public void testSelectAll() throws Exception {
        CouponExample example=new CouponExample();
        Criteria criteria = example.createCriteria();
        criteria.andActivedIsNotNull();
        List<Coupon> list = couponMapper.selectByExample(example);
        Assert.assertEquals(9, list.size());
    }
    
    
    
    
}
