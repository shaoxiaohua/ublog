package com.ysm.ublog.utils;




import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.net.URL;



public class FastDfsUtils {

    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private StorageServer storageServer;

    public FastDfsUtils(String configlocation) throws IOException, MyException {
        //classpath:conf.properties ===>从项目路径找这个conf的文件,然后转换成绝对路径
        if (configlocation.startsWith("classpath")) {
            //从项目路径中查找文件
            configlocation = configlocation.replace("classpath:", getClass().getResource("/").getPath());

//            ClassLoader classLoader = FastDfsUtils.class.getClassLoader();//获取类加载器
//            String path = classLoader.getResource("/").getPath();//获取项目所在的目录位置

        }
        //"classpath:xxx.conf"
        ClientGlobal.init(configlocation);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();

    }

    public String fileUpload(byte[] bs, String ext_name) throws IOException, MyException {
        return fileUpload(bs, ext_name, null);
    }

    public String fileUpload(byte[] bs, String ext_name, NameValuePair[] valuePair) throws IOException, MyException {
        StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
        String[] resultString = storageClient1.upload_file(bs, ext_name, valuePair);

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < resultString.length; i++) {
            stringBuffer.append(resultString[i]);
            if (i == 0) {
                stringBuffer.append("/");
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String config = "classpath:conf.properties";
        URL resource = FastDfsUtils.class.getResource("/");
        config = config.replace("classpath:", resource.getPath());
        System.out.println(config);
    }
}
