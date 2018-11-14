package com.ysm.ublog.contact.service.impl;

import com.ysm.ublog.contact.pojo.Contact;
import com.ysm.ublog.contact.service.ContactService;
import com.ysm.ublog.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/7 12:09.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper mapper;
    @Override
    public List<Contact> getAllContact(int fid) {
        return mapper.getAllContact(fid);
    }

    @Override
    public void delContact(int uid, int fid) throws Exception{
        mapper.delContact(uid,fid);
    }
}
