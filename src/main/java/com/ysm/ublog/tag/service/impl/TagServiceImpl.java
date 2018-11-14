package com.ysm.ublog.tag.service.impl;

import com.ysm.ublog.mapper.TagMapper;
import com.ysm.ublog.tag.entity.T_tags;
import com.ysm.ublog.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public void addTags(T_tags t_tags) {
        tagMapper.addUserTag(t_tags);
    }
}
