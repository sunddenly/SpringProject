package com.hebut.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/fileUpload")
    public String testFileUpload(@RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file,
                                 HttpServletRequest request,
                                 ModelMap model) throws IOException {
        //获取存储文件的:路径和文件名
        String path= request.getSession().getServletContext().getRealPath("fileUpload");
        System.out.println("path"+path);

        String fileName= file.getOriginalFilename();
        System.out.println("fileName"+fileName);

        //判断存储路径的有效性
        File targetPath = new File(path);
        if(!targetPath.exists())
            targetPath.mkdir();
        File targetFile = new File(targetPath, fileName);

        //保存上传文件
        file.transferTo(targetFile);

        //与上面的不同getContextPath获取的是：请求应用名
        //model中放的是请求获取上传文件的url
        model.addAttribute("fileUrl", request.getContextPath()+"/fileUpload/"+fileName);
        return "success";
    }
}
