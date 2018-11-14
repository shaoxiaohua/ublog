package com.ysm.ublog.activity.contoller;

import com.ysm.ublog.activity.pojo.Category;
import com.ysm.ublog.activity.service.CategoryService;
import com.ysm.ublog.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hua
 * @date 2018/11/6 14:57.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/findallcategory")
    @CrossOrigin
    public ResultBean findAllCategory(){
//        从redis中取出所有的分类
        List<Category> allCategory = categoryService.findAllCategoryFromRedis();
        ResultBean resultBean = ResultBean.setOk(0, "返回分类成功", allCategory);
        return resultBean;
    }
}
