package com.ztcly.shop.Controller;

import com.ztcly.shop.Service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Scope("prototype")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    /**
     * 下载
     *
     * @param name
     * @param response
     * @throws Exception
     */
    @GetMapping("/download/{name}")
    public void logDownload(@PathVariable String name, HttpServletResponse response) throws Exception {
        downloadService.logDownload(name, response);
    }

}
