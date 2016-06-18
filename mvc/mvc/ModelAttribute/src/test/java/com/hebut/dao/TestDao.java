package com.hebut.dao;

import com.hebut.exception.NameOrPwdException;
import com.hebut.exception.NullParamException;
import com.hebut.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by jxy on 2016/6/14.
 */
public class TestDao {
    String conf = "/config/spring/mvc-modelAttribute.xml";
    ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
    //测试UserService是否注入
    @Test
    public void testUserService() throws NameOrPwdException, NullParamException, SQLException {
        UserService service = ac.getBean("userService", UserService.class);
        System.out.println(service.login("Tom","123"));

    }
}
