<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.FileInputStream" %><%--
  Created by IntelliJ IDEA.
  User: ztcly
  Date: 2021/10/12
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page language="java" contentType="application/download" pageEncoding="gb2312"%>
<%
    //关于文件下载时采用文件流输出的方式处理：
    //加上response.reset()，并且所有的％>后面不要换行，包括最后一个；

    //response.reset();//可以加也可以不加
    //response.setContentType("application/x-download");

//application.getRealPath("/main/mvplayer/CapSetup.msi");获取的物理路径
    String filename = (String)session.getAttribute("filename");
    String filedownload = "D:/jav/netdisk/cache/"+filename;
    String filedisplay = filename;
    filedisplay = URLEncoder.encode(filedisplay,"UTF-8");
    response.addHeader("Content-Disposition", "attachment;filename=" + filedisplay);
//    response.addHeader("Content-Disposition","p_w_upload;filename=" + filedisplay);

    out.clear();
    out = pageContext.pushBody();

    java.io.FileInputStream in = null;
    in = new FileInputStream(filedownload);
    response.setContentLength(in.available());
    java.io.OutputStream outp = null;
    try
    {
        outp = response.getOutputStream();


        byte[] b = new byte[1024];
        int i = 0;

        while((i = in.read(b)) > 0)
        {
            outp.write(b, 0, i);
        }

//        outp.flush();
        outp.close();
        in.close();
        response.flushBuffer();

//要加以下两句话，否则会报错
//java.lang.IllegalStateException: getOutputStream() has already been called for //this response

    }
    catch(Exception e)
    {
        System.out.println("Error!");
        e.printStackTrace();
    }
    finally
    {
        if(in != null)
        {
            in.close();
            in = null;
        }
//这里不能关闭
//if(outp != null)
        //{
        //outp.close();
        //outp = null;
        //}
    }
%>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
    文件下载
</body>
</html>
