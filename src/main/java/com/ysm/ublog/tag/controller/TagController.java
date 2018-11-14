package com.ysm.ublog.tag.controller;

import com.ysm.ublog.tag.entity.T_tags;
import com.ysm.ublog.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/addtags")
    public String addtags(@RequestBody T_tags t_tags){
        tagService.addTags(t_tags);
        return "success";
    }

}
