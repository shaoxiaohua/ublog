package com.ysm.ublog.mapper;

import com.ysm.ublog.contact.pojo.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/7 12:11.
 */
public interface ContactMapper {
//    获取所有的联系人
    List<Contact> getAllContact(@Param("fid") int fid);

    void delContact(@Param("uid") int uid, @Param("fid") int fid);
}
