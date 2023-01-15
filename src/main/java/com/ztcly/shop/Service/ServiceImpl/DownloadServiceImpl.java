package com.ztcly.shop.Service.ServiceImpl;

import com.ztcly.shop.Service.DownloadService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
@Service
public class DownloadServiceImpl implements DownloadService {

    @Override
    public void logDownload(String name, HttpServletResponse response) throws Exception {
        String filedownload = "D:/jav/netdisk/cache/"+name;
        File file = new File(filedownload);


        if (!file.exists()) {
            throw new IOException();
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + name);

        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }
    }
}
