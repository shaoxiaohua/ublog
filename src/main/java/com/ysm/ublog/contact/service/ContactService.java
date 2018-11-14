package com.ysm.ublog.contact.service;

import com.ysm.ublog.contact.pojo.Contact;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/7 12:09.
 */
public interface ContactService {
    /**
     * 获取所有的联系人列表
     * @return
     */
    List<Contact> getAllContact(int fid);

    void delContact(int uid, int fid) throws Exception;
}
