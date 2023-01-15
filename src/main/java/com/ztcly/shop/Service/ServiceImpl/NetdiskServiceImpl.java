package com.ztcly.shop.Service.ServiceImpl;
import com.ztcly.shop.Service.NetdiskService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
@Service
public class NetdiskServiceImpl implements NetdiskService {
    private static int filesnum;
    String hdfsaddr = "hdfs://192.168.232.135:9000";
    String hdfsname = "fs.defaultFS";
    @Override
    public boolean removeFile(String hdfspath) throws IOException {
        Configuration conf = new Configuration(); // 配置文件对象
        // 设置连接HDFS地址
        conf.set(hdfsname, hdfsaddr);
        conf.setBoolean("fs.hdfs.impl.disable.cache", true);

        // 获取操作文件的路径
        Path delefPath = new Path(hdfspath);
        // 获得HDFS文件操作对象，此类封装了对文件的所有操作，包括删除、修改
        FileSystem hdfs = delefPath.getFileSystem(conf);
        boolean retval = false;
        if (hdfs.exists(delefPath)) {
            retval = hdfs.delete(delefPath, true);
            System.out.println("文件删除成功");
        }
        return retval;
    }

    @Override
    public boolean reNameFile(String oldPath, String newPath) throws IllegalArgumentException, IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);

        boolean retval = fs.rename(new Path(oldPath), new Path(newPath));// 重命名
        fs.close();

        return retval;

    }

    @Override
    public boolean removeDir(String hdfsDir) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);

        boolean retval = fs.delete(new Path(hdfsDir));

        fs.close();

        return retval;

    }

    @Override
    public FileStatus[] getAllFileStatus(String dir) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);
        FileStatus[] stats = fs.listStatus(new Path(dir));

        return stats;

    }

    @Override
    public boolean moveFileTo(String oldPath, String newPath) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);
        fs.moveFromLocalFile(new Path(oldPath), new Path(newPath));
        fs.close();

        return true;

    }

    @Override
    public boolean copyFileTo(String oldPath, String newPath) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);

        fs.copyToLocalFile(new Path(oldPath), new Path(newPath));
        fs.close();

        return true;

    }

    @Override
    public boolean isPathExists(String hdfsPath) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);

        boolean exists = fs.exists(new Path(hdfsPath));
        if (!exists) {
            fs.mkdirs(new Path(hdfsPath));
            fs.close();
            return false;
        }
        fs.close();
        return true;

    }

    @Override
    public int createDir(String hdfsPath, String dirName) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);
        System.out.println("该文件夹###0!" + hdfsPath);
        String path = hdfsPath + dirName;
        System.out.println("该文件夹###00!" + path);
        boolean exists = fs.exists(new Path(path));
        if (!exists) {
            System.out.println("该文件夹###1!" + path);
            boolean result = fs.mkdirs(new Path(path + dirName));
            System.out.println("该文件夹###2!" + result);
            if (result == true)
                return 0;
            else
                return 1;
        } else {
            System.out.println("该文件夹已经存在!");
            return -1;
        }


    }

    @Override
    public boolean uploadFile(String hdfsPath, String filePath) throws IOException {

        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem hdfs = FileSystem.get(conf);
        System.out.println("[Netdiskimpl]:"+hdfsPath+" / "+filePath);

        Path src = new Path(filePath);
        Path dst = new Path(hdfsPath);
        System.out.println("[Netdiskimpl]:"+src+" to "+dst);
        hdfs.copyFromLocalFile(src, dst);

        System.out.println("Up Load Done\n");
        hdfs.close();

        return true;


    }

    @Override
    public boolean downLoadFile(String hdfsPath, String filePath) throws IOException {

        Configuration conf = new Configuration();
        Path hadoopPath = new Path(hdfsPath);
        conf.setBoolean("fs.hdfs.impl.disable.cache", true);
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
        FSDataInputStream hdfsInStream = fs.open(hadoopPath);
        OutputStream out = new FileOutputStream(filePath);

        byte[] ioBuffer = new byte[1024];

        int readLen = hdfsInStream.read(ioBuffer);

        while (-1 != readLen) {

            out.write(ioBuffer, 0, readLen);
            readLen = hdfsInStream.read(ioBuffer);
        }

        System.out.println("DownLoad Done!");
        out.close();
        hdfsInStream.close();
        fs.close();

        return true;

    }

    @Override
    public List<String> listAll(String dir) throws IOException {
        Configuration conf = new Configuration();
        conf.set(hdfsname, hdfsaddr);
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(dir);
        FileStatus[] stats = fs.listStatus(path);

        List<String> dfname = new ArrayList<String>();

        filesnum = stats.length;

        for (int i = 0; i < stats.length; ++i) {
            //dfname.set(i, stats[i].getPath().toString());
            String fileHdfsPath = stats[i].getPath().toString();
            String[] fileHdfsPathSp = fileHdfsPath.split("/");
            dfname.add(fileHdfsPathSp[fileHdfsPathSp.length-1]);
        }

        fs.close();

        return dfname;

    }
}
