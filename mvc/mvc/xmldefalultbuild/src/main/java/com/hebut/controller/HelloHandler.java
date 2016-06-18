package com.hebut.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jxy on 2016/6/10.
 */
public class HelloHandler implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("describe","Spring MVC");
        return new ModelAndView("hello",map);
        //http://localhost:8080/mvc-xml/dealult/login.form
    }
}
