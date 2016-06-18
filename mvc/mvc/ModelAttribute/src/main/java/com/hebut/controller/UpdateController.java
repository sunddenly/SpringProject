package com.hebut.controller;

import com.hebut.dao.UserDao;
import com.hebut.entity.Dept;
import com.hebut.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

import java.util.Map;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UpdateController {
    //自动匹配注入userDao，或者为@Resource(name="mysqlUserDao")
    @Resource
    private UserDao userDao;

    @RequestMapping("/toinfo")
    public String info(@ModelAttribute("name") String name,@ModelAttribute("user")User userinfo, ModelMap model){
        //测试绑定参数的内容
        System.out.println("userInfo："+userinfo);
        System.out.println("name："+name);

        //测试是否将name放入了Model中，Model中的内容应该和表单参数组合后的内容
        name = model.get("name").toString();
        System.out.println("Model name:"+name);

        //测试是否将user放入了Model中，Model中的内容应该和表单参数组合后的内容
        User user = (User)model.get("user");
        System.out.println("Model user:"+user);

        //测试是否将abc放入了Model中，Model中的内容应该和表单参数组合后的内容
        User abc = (User)model.get("abc");
        System.out.println("Model abc:"+abc);
        return "index";
    }

    @ModelAttribute("user")//通过注解，指定存入对象的key值
    public User getUser(){
        User user = userDao.findByName("Tom");
        System.out.println("方式一：从数据库获取一个user对象，key=abc");
        System.out.println(user);
        if (user!=null)
            return user;
        return null;
    }

    @RequestMapping("/tosession")
    public String toSession(User user,Map<String,Object> map){
        user = new User(101,"Jiangxinyu","4456","273rf");
        map.put("user",user);
        return "index";
    }




























    //即使方法中不绑定任何参数，但在该方法执行时会先把所有@ModelAttribute标注方法执行完毕
    @RequestMapping("/toIndex2")
    public String index2(){
        System.out.println("=========================");
        System.out.println("index2");
        return "index";
    }

}
