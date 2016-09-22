package com.hebut.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller
public class UploadController {
    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
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
        //http://localhost:8080/fileUpload
        //http://localhost:8080/fileUpload
        file.transferTo(targetFile);

        //与上面的不同getContextPath获取的是：请求应用名
        //model中放的是请求获取上传文件的url
        model.addAttribute("fileUrl", request.getContextPath()+"/fileUpload/"+fileName);
        System.out.println(request.getContextPath()+"/fileUpload/"+fileName);
        return "success";
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    @ResponseBody
    public LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        //1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;

        //2. get each file
        while(itr.hasNext()){

            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());
            System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());

            //2.2 if files > 10 remove the first from the list
            if(files.size() >= 10)
                files.pop();

            //2.3 create new fileMeta
            fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());
            String path= request.getSession().getServletContext().getRealPath("fileUpload");
            File targetPath = new File(path);
            if(!targetPath.exists())
                targetPath.mkdir();
            try {
                fileMeta.setBytes(mpf.getBytes());
                // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                File targetFile = new File(targetPath, mpf.getOriginalFilename());
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(targetFile));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //2.4 add to files
            files.add(fileMeta);

        }

        // result will be like this
        // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
        return files;

    }
    /***************************************************
     * URL: /rest/controller/get/{value}
     * get(): get file as an attachment
     * @param response : passed by the server
     * @param value : value from the URL
     * @return void
     ****************************************************/
    @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
    public void get(HttpServletResponse response,@PathVariable String value){
        FileMeta getFile = files.get(Integer.parseInt(value));
        try {
            response.setContentType(getFile.getFileType());
            response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
            FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
