package com.ztcly.shop.Service;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {
    public void logDownload(String name, HttpServletResponse response) throws Exception;
}
