package com.example.lambadatest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author ChenXingNan
 * @Date 2020/11/19 16:29
 **/
@Api("文件上传下载")
@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    /**
     * 实现文件上传
     *
     * @param file
     * @return
     */
    @ApiOperation("文件上传")
    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "--->" + size);
        String path = "C:/develop/myfiles";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }

    /**
     * 多文件上传
     * @param request
     * @return
     */
    @PostMapping("/multifileUpload")
    public String multifileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        if (files.isEmpty()) {
            return "false";
        }
        String path = "C:/develop/myfiles";
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            if (file.isEmpty()) {
                return "false";
            } else {
                File dest = new File(path + "/" + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);

                } catch (IOException e) {
                    e.printStackTrace();
                    return "false";
                }
            }

        }
        return "true";

    }
    @GetMapping("/fileDownload")
    public String fileDownload(HttpServletRequest request, HttpServletResponse response){
        String fileName="3.txt";
        if (fileName!=null){
            //设置文件路径
            File file=new File("C:\\develop\\myfiles\\2.txt");
            if (file.exists()){
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition","attachment;fileName="+fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis=null;
                BufferedInputStream bis=null;
                try {
                    fis = new FileInputStream(file);
                    bis =new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i!=-1){
                        os.write(buffer,0,i);
                        i = bis.read(buffer);
                    }
                    return "download success";
                }catch ( Exception e){
                    e.printStackTrace();
                }finally {
                    try {
                        bis.close();
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        }
        return "null";

    }

}
