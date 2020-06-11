package com.smart.patry.provider.service;

import com.smart.patry.provider.api.PatryAdminService;
import com.smart.patry.provider.domain.PatryAdmin;
import com.smart.patry.provider.mapper.PatryAdminMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * PatryAdminServiceImpl Tester.
 *
 * @author <Authors name>
 * @since <pre>4�� 26, 2020</pre>
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class PatryAdminServiceImplTest {

    @Resource
    private PatryAdminMapper patryAdminMapper;
    //    接口
    @Resource
    private PatryAdminService patryAdminService;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     *
     * Method: insert(PatryAdmin patryAdmin)
     *
     */
    @Test
    public void testInsert() throws Exception {
        PatryAdmin patryAdminInsert = new PatryAdmin();

//        patryAdminInsert.setPatryAdminLoginidentity("党总支");
//        patryAdminInsert.setPatryAdminId("300004");
//        patryAdminInsert.setPatryAdminPassword("300004");
//        patryAdminInsert.setPatryAdminName("王四娃");
//        patryAdminInsert.setPatryAdminUnit("建科党总支");

        int result = patryAdminService.insert(patryAdminInsert);
        Assert.assertEquals(result, 1);
    }

    /**
     *
     * Method: get(Integer patryAdminId)
     *
     */
    @Test
    public void testGet() throws Exception {
    System.out.println(patryAdminMapper.selectByPrimaryKey("300004"));
    }
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("300001");
        System.out.println(passwordEncoder.encode("300001"));
        System.out.println("300002");
        System.out.println(passwordEncoder.encode("300002"));
        System.out.println("300003");
        System.out.println(passwordEncoder.encode("300003"));
    }
}
