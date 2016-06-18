package com.hebut.international;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class InternalController {
    @Autowired
    private ResourceBundleMessageSource messageSource;
    @RequestMapping("/i18n")
    public String testI18n(Locale locale){
        // 获取本地资源信息对象
        String user = messageSource.getMessage("i18n.user", null, locale);
        System.out.println(user);
        String pwd = messageSource.getMessage("i18n.password", null, locale);
        System.out.println(pwd);
        return "i18n1";
    }
}
