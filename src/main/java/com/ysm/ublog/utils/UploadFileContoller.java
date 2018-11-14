package com.ysm.ublog.utils;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author CREATED BY hua
 * @date 2018/11/13 10:53.
 * @since jdk1.8
 */
@RestController
@RequestMapping("/upload")
public class UploadFileContoller {
    @Autowired
    private FastDfsUtils fastDfsUtils;
    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    public ArrayList uploadFile(MultipartFile file1,MultipartFile file2,MultipartFile file3,MultipartFile file4,MultipartFile file5){
        ArrayList<String> list = new ArrayList<String>();
        try {

            String originalFilename = file1.getOriginalFilename();
            String ext_name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileaddress = fastDfsUtils.fileUpload(file1.getBytes(), ext_name);

            String originalFilename2 = file2.getOriginalFilename();
            String ext_name2 = originalFilename2.substring(originalFilename2.lastIndexOf(".") + 1);
            String fileaddress2 = fastDfsUtils.fileUpload(file2.getBytes(), ext_name2);

            String originalFilename3 = file3.getOriginalFilename();
            String ext_name3 = originalFilename3.substring(originalFilename3.lastIndexOf(".") + 1);
            String fileaddress3 = fastDfsUtils.fileUpload(file3.getBytes(), ext_name3);

            String originalFilename4 = file4.getOriginalFilename();
            String ext_name4 = originalFilename4.substring(originalFilename4.lastIndexOf(".") + 1);
            String fileaddress4 = fastDfsUtils.fileUpload(file4.getBytes(), ext_name4);

            String originalFilename5 = file5.getOriginalFilename();
            String ext_name5 = originalFilename5.substring(originalFilename5.lastIndexOf(".") + 1);
            String fileaddress5 = fastDfsUtils.fileUpload(file5.getBytes(), ext_name5);

            list.add(fileaddress);
            list.add(fileaddress2);
            list.add(fileaddress3);
            list.add(fileaddress4);
            list.add(fileaddress5);

            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
