package com.ysm.ublog.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageSendUtils {
    //开发者猪账号id，（注册以后自动生成）
    public static final String ACCOUNT_SID="cbe62e510e1540e48695ccae3ca20247";
    //开发者账号认证密匙（注册后自动生成）
    public static final String AUTH_TOKEN = "9a046c077e684a43bc5fcb875cbbe168";
    //用户请求地址
    public static final String BASE_URL="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    //获取随机数字
    static String randomNum = getRandom();
    //短信内容（短信签名+短信内容，必须和模板一样，否则会出错）
    public static String smsContent ="【千峰教育】您的验证码为"+randomNum+"，请于2分钟内正确输入，如非本人操作，请忽略此短信。";
    //数据返回格式是json格式
    public static final String RESP_DATA_TYPE="json";


    public static String getRandom(){
        String randomnummber = RandomNumUtils.randomnummber(6);
        return randomnummber;
    }

    public static String getTimestamp(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = simpleDateFormat.format(new Date());
        return timestamp;
    }

    public static String sig_MD5(String string){
        String hex = DigestUtils.md5Hex(string);
        return hex;
    }

    public static String sendMessage(String to){
        //获取时间戳
        String timetamp = getTimestamp();
       //获取签名
        String sig =sig_MD5(ACCOUNT_SID+AUTH_TOKEN+timetamp);
        //要提交的数据??????????????????????/
        String http_post="accountSid="+ACCOUNT_SID+"&smsContent="+smsContent+"&to="+to+"&timestamp="+timetamp
                +"&sig="+sig+"&respDataType="+RESP_DATA_TYPE;
        OutputStreamWriter osw = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            //获取连接
            URL url = new URL(BASE_URL);
            //打开连接
            URLConnection conn = url.openConnection();
            //设置连接参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            //提交数据
            osw = new OutputStreamWriter(conn.getOutputStream());
            osw.write(http_post);
            osw.flush();

            //读取并返回数据
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line="";
            while ((line=br.readLine())!=null){
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String messageSendAndgetRandom(String mobile){
        sendMessage(mobile);
        return randomNum;
    }

    public static void main(String[] args){
        System.out.println("验证码是："+randomNum);
        System.out.println(getTimestamp());
        String message = sendMessage("17610002602");
        System.out.println(message);

    }
}
