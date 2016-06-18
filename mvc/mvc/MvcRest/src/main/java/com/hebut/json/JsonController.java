package com.hebut.json;

import com.hebut.crud.dao.EmployeeDao;
import com.hebut.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

@Controller
public class JsonController {
    @Autowired
    private EmployeeDao employeeDao;

    //测试JSON
    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }
    /**
     * [文件上传]
     * 测试 @ResponseBody/@RequestBody
     * 1. @RequestBody：将上传的文件信息绑定到字符串
     * 2. @ResponseBody：将响应的字符串信息以Json格式返回给客户端
     */

    @ResponseBody
    @RequestMapping("/rsponseBody")
    public String testResponseBody(@RequestBody String body){
        System.out.println(body);
        return "helloworld! " + new Date();
    }
    /**
     * [文下载]
     * 测试 ResponseEntity/HttpEntity
     * 1. HttpEntity：接受并打印请求信息
     * 2. ResponseEntity：将响应信息返回给客户端
     */
    @RequestMapping("/responseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpEntity<String> entity,
                           HttpSession session) throws IOException {
        //获取请求信息
        System.out.println(entity.getHeaders().getContentLength());
        //输出响应信息
        byte [] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/static/files/abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }
}
