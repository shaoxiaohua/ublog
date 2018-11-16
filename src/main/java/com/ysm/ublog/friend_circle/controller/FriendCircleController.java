package com.ysm.ublog.friend_circle.controller;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import com.ysm.ublog.friend_circle.entity.T_friend_circle_message;
import com.ysm.ublog.friend_circle.service.FriendCircleService;
import com.ysm.ublog.myinfo.pojo.t_user;
import com.ysm.ublog.user.pojo.T_user;
import com.ysm.ublog.utils.FastDfsUtils;
import com.ysm.ublog.utils.GetDateTimeUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/friendcircle")
public class FriendCircleController {
     @Autowired
    private FriendCircleService friendCircleService;

   //添加朋友圈
    @RequestMapping(value="/submitcontent",method = RequestMethod.POST)
    @ResponseBody
    public T_friend_circle_message submitFriend(@RequestBody T_friend_circle_message t_friend_message, MultipartFile file1, MultipartFile file2, MultipartFile file3, HttpServletRequest request) throws IOException, MyException {

        /*将图片添加到服务器中
      for (MultipartFile multipartFile : multipartFiles) {
            String originalFilename = multipartFile.getOriginalFilename();house
            //然后添加地址
        }*/
        StringBuffer buffer = new StringBuffer();

        String originalFilename = file1.getOriginalFilename();
        String ext_name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileaddress = FastDfsUtils.fileUpload(file1.getBytes(), ext_name);

        buffer.append(fileaddress);

        String originalFilename1 = file2.getOriginalFilename();
        String ext_name1 = originalFilename.substring(originalFilename1.lastIndexOf(".") + 1);
        String fileaddress1 = FastDfsUtils.fileUpload(file2.getBytes(), ext_name1);

        buffer.append(fileaddress1);

        String originalFilename2 = file3.getOriginalFilename();
        String ext_name2 = originalFilename.substring(originalFilename2.lastIndexOf(".") + 1);
        String fileaddress2 = FastDfsUtils.fileUpload(file3.getBytes(), ext_name2);

        buffer.append(fileaddress2);

        System.out.println(buffer);

        String location = request.getRemoteAddr();
        t_friend_message.setLocation(location);
        t_friend_message.setPicture(buffer.toString());
        t_friend_message.setCreatetime(GetDateTimeUtils.getNowTime());
        //1代表全部可见，0代表自己可见
        t_friend_message.setIsown(1);
        System.out.println(t_friend_message.getId()+"........................................");
        friendCircleService.addFriendMessage(t_friend_message);
        return t_friend_message;
    }
//查询所有朋友圈
    @RequestMapping("/getallmessage")
    @ResponseBody
    public String getallmessage(HttpServletRequest request){
        T_user user =(T_user) request.getSession().getAttribute("user");
        List<T_friend_circle_message> messages = friendCircleService.getAllMessage(user.getId());
        return messages.toString()+user.getId();
    }
    //添加评论
   @RequestMapping("/sendcomment")
   @ResponseBody
    public T_friend_circle_comment sendComment(@RequestBody T_friend_circle_comment t_friend_circle_comment) throws IOException {
         if(t_friend_circle_comment.getContent()!=null) {
             t_friend_circle_comment.setCreate_time(GetDateTimeUtils.getNowTime());
             friendCircleService.addComment(t_friend_circle_comment);
         }
         return t_friend_circle_comment;
    }

}
