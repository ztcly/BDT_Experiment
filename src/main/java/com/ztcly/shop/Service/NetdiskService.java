package com.ztcly.shop.Service;

import org.apache.hadoop.fs.FileStatus;

import java.io.IOException;
import java.util.List;

public interface NetdiskService {
    public boolean removeFile(String hdfspath) throws IOException;
    public boolean reNameFile(String oldPath,String newPath) throws IllegalArgumentException,IOException;
    public boolean removeDir(String hdfsDir) throws IOException;
    public FileStatus[] getAllFileStatus(String dir) throws IOException;
    public boolean moveFileTo(String oldPath,String newPath) throws IOException;
    public boolean copyFileTo(String oldPath,String newPath) throws IOException;
    public boolean isPathExists(String hdfsPath) throws IOException;
    public int createDir(String hdfsPath,String dirName) throws IOException;
    public boolean uploadFile(String hdfsPath,String filePath) throws IOException;
    public boolean downLoadFile(String hdfsPath,String filePath) throws IOException;
    public List<String> listAll(String dir) throws IOException;



}
