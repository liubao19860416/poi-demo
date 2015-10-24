package project.base.poi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saike.grape.base.BaseEnvironment;

/**
 * DAO层基础测试类，加载junit+spring环境 OK
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext*.xml" })
public class BaseDAOTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBaseEnvironment() throws Exception {
        Assert.assertEquals("LOCAL", BaseEnvironment.SYS_ENV);
    }

}
