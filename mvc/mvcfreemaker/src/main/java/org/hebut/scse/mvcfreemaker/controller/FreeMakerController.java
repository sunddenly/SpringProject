package org.hebut.scse.mvcfreemaker.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.hebut.scse.mvcfreemaker.pojo.JsonResponse;
import org.hebut.scse.mvcfreemaker.pojo.User;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17/2/11.
 */
@Controller
public class FreeMakerController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        User user = new User();
        user.setUsername("tangqing");
        user.setPassword("1234");
        List<User> users = new ArrayList<User>();
        users.add(user);
        return new ModelAndView("index", "users", user);
    }
    @RequestMapping("/get")
    public void get(HttpServletRequest req,HttpServletResponse res) {
        res.setContentType("text/plain");
        String callbackFunName =req.getParameter("callbackparam");//得到js函数名称
        try {
            res.getWriter().write(callbackFunName + "([ { name:\"John\"}])"); //返回jsonp数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/jsonp", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJsonPData(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("bbbbb");
        String jsoncallback = request.getParameter("jsoncallback");
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
        return new JSONPObject(jsoncallback,user);
    }

    @RequestMapping(value = "/jsonp2", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJsonp2Data(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("deee");
        String callbackFunName =request.getParameter("callbackparam");//得到js函数名称
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
        return new JSONPObject(callbackFunName,user);
    }

    @RequestMapping(value = "/jsonp3", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJsonp3Data(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
        return new JSONPObject("jsonpCallBack",user);
    }

    @RequestMapping(value = "/jsonp4", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJsonp4Data(HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
//        mappingJacksonValue.setJsonpFunction("success_jsonpCallback");
        return new JSONPObject("success_jsonpCallback",user);
    }


    @RequestMapping(value = "/jsonp5", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJsonp5Data(HttpServletRequest request, HttpServletResponse response) {
        JsonResponse<User> userJsonResponse = new JsonResponse<User>();
        User user = new User();
        user.setPassword("2332");
        user.setUsername("qweqweq");
        userJsonResponse.setCode(-1);
        userJsonResponse.setData(user);
        userJsonResponse.setMessage("info");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        mappingJacksonValue.setJsonpFunction("success_jsonpCallback");
        return new JSONPObject("success_jsonpCallback",userJsonResponse);
    }
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public User getJsonData(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-------------------------");
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
        response.setHeader("Access-Control-Allow-Origin", "*");
        return user;
    }
    @RequestMapping(value = "/json2", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getJson2Data(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("-------------------------");
        String callback = request.getParameter("callback");
        User user = new User();
        user.setUsername("JiangXinyu");
        user.setPassword("qweqweqw");
        return new JSONPObject(callback,user);
    }
}


