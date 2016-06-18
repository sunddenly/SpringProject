package com.hebut.controller;

import com.hebut.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by jxy on 2016/6/14.
 */
@Controller
@RequestMapping("/session")
@SessionAttributes("user")
public class SessiongController {
    @RequestMapping("/tosession1")
    public String testSession(User user){//Spring MVC自动将user放入Request对象中
        System.out.println("session1:"+user);

        return "index";
    }

    @RequestMapping("/tosession2")
    public String testSession2(User user,Map<String,Object> map){
        //Spring MVC会自动将user放入Request对象中
        //但是Model中也入了一个user对象
        //Model中的优先级高于Request，所以Session中存储的是Model中的user
        System.out.println("session2:"+user);
        user = new User(101,"Jiangxinyu","4456","273rf");
        map.put("user",user);
        return "index";
    }
}
