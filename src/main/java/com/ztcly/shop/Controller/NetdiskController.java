package com.ztcly.shop.Controller;

import com.ztcly.shop.Service.NetdiskService;
import com.ztcly.shop.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
public class NetdiskController {
    @Autowired
    HttpSession session;
    @Autowired
    private NetdiskService netdiskService;
    String hdfsaddr = "hdfs://192.168.232.135:9000/user/root/";
    @RequestMapping("/netdisk")
    public String netdisk(Model model)
    {
        String userid = (String)session.getAttribute("userid");
        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法进入云盘（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }else {
            //String dir = hdfsaddr + userid;
            try {

                List<String> filelist = netdiskService.listAll(userid);
                System.out.println("[NetdiskController]netdiskListIsEmpty:"+ filelist.isEmpty());
                session.setAttribute("filelistisempty",filelist.isEmpty());
                model.addAttribute("filelist",filelist);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "netdiskpage";
        }
    }


    @RequestMapping("/deletefile")
    public String deletefile(String file) {
        String userid = (String)session.getAttribute("userid");
        String fileaddr = hdfsaddr + userid + "/"+file;
        //String fileaddr = hdfsaddr + userid + file;
        try {
            netdiskService.removeFile(fileaddr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[NetdiskController]deletefile触发:" + file);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/netdisk";
    }
    @RequestMapping("/download0")
    public String downloadfile(String file) {
        String userid = (String)session.getAttribute("userid");
        String fileaddr = hdfsaddr + userid + "/"+file;
        //String fileaddr = hdfsaddr + userid + file;
        String filePath = "D:/jav/netdisk/cache/";
        String localFilePath = filePath + file;
        try {
            netdiskService.downLoadFile(fileaddr,localFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("[NetdiskController]downloadfile触发:" + file);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //model.addAttribute("filename",file);
        session.setAttribute("filename",file);
//        try {
//            response.sendRedirect("downloadfile.jsp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "downloadfile";
    }
    @RequestMapping("/uploadfile")
    public String uploadfile(MultipartFile file, Model model){
        String userid = (String)session.getAttribute("userid");

        if(userid==null){
            Error error = new Error();
            error.setErrortitle("无法创建商品（未登入）");
            error.setErrorinfo("请先进行登入");
            error.setNextpage("loginpage");
            error.setNextpagetitle("登入");
            model.addAttribute("error",error);
            return "error";
        }else {
            if (file.isEmpty()) {
                Error error = new Error();
                error.setErrortitle("上传文件错误");
                error.setErrorinfo("错误：未读取到文件");
                error.setNextpage("netdisk");
                error.setNextpagetitle("回到云盘");
                model.addAttribute("error", error);
                return "error";
            } else {
                String filename = file.getOriginalFilename();
                String filePath = "D:/jav/netdisk/cache/";
                String localFilePath = filePath + filename;
                File dest = new File(filePath + filename);
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String fileaddr = hdfsaddr + userid + "/"+file.getOriginalFilename();
                try {
                    netdiskService.uploadFile(fileaddr, localFilePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/netdisk";
    }
}
