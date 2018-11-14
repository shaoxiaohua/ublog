package com.ysm.ublog.contact.contoller;

import com.ysm.ublog.bean.ResultBean;
import com.ysm.ublog.contact.pojo.Contact;
import com.ysm.ublog.contact.service.ContactService;
import com.ysm.ublog.utils.ErrorCodeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/7 11:57.
 */
@RestController
@RequestMapping("/contact")
public class ContactContoller {
    @Autowired
    private ContactService contactService;
//获取好友列表
    @RequestMapping("/getallcontact")
    @CrossOrigin
    public ResultBean getAllContact(@RequestParam("fid") int fid){
        List<Contact> allContact = contactService.getAllContact(fid);
        return ResultBean.setOk(ErrorCodeInterface.SUCCESS, "返回好友列表成功", allContact);
    }
//    删除联系人，仅仅将状态改为1而已不是真正的将好友进行删除
    @RequestMapping("/delContact")
    @CrossOrigin
    public ResultBean delContact(int uid,int fid){
        try {
            contactService.delContact(uid,fid);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBean.setError(1001, "删除好友失败!");
        }
        return ResultBean.setOk(ErrorCodeInterface.SUCCESS, "删除好友成功", null);
    }

}
