package com.ysm.ublog.friend_circle.controller;

import com.ysm.ublog.friend_circle.entity.T_friend_circle_comment;
import com.ysm.ublog.friend_circle.entity.T_friend_circle_message;
import com.ysm.ublog.friend_circle.service.FriendCircleService;
import com.ysm.ublog.utils.GetDateTimeUtils;
import com.ysm.ublog.utils.RandomNumUtils;
import com.ysm.ublog.utils.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/friendcircle")
public class FriendCircleController {
     @Autowired
    private FriendCircleService friendCircleService;

   //添加朋友圈
    @RequestMapping(value="/submitcontent",method = RequestMethod.POST)
    @ResponseBody
    public String submitFriend(@RequestBody T_friend_circle_message t_friend_message,HttpServletRequest request){

        /*将图片添加到服务器中
      for (MultipartFile multipartFile : multipartFiles) {
            String originalFilename = multipartFile.getOriginalFilename();house
            //然后添加地址
        }*/

        String location = request.getRemoteAddr();
        t_friend_message.setLocation(location);
        t_friend_message.setCreatetime(GetDateTimeUtils.getNowTime());
        //1代表全部可见，0代表自己可见
        t_friend_message.setIsown(1);
        t_friend_message.setId("ysmmessage"+RandomNumUtils.randomnummber(3));

        friendCircleService.addFriendMessage(t_friend_message);
        String message = ToJson.toJson(t_friend_message);
        return message;
    }
//查询所有朋友圈
    @RequestMapping("/getallmessage")
    @ResponseBody
    public String getallmessage(){
        String messages = friendCircleService.getAllMessage();
        return messages;

    }
    //添加评论
   @RequestMapping("/sendcomment")
   @ResponseBody
    public String sendComment(@RequestBody T_friend_circle_comment t_friend_circle_comment) throws IOException {
         if(t_friend_circle_comment.getContent()!=null){
             t_friend_circle_comment.setCreate_time(GetDateTimeUtils.getNowTime());
             friendCircleService.addComment(t_friend_circle_comment);
         }else{
             return "error";
         }
       String comment = ToJson.toJson(t_friend_circle_comment);
       return comment;
    }

}
