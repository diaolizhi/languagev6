package com.hzxy.show.web.api;

import com.hzxy.domain.entity.Category;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.hzxy.domain.utils.pageResult;
import com.hzxy.show.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//分类接口
@RestController
@RequestMapping("/show/category")
public class CategoryController1 {
  @Autowired
    private CategoryService categoryService;

  /*获取该系统下的所有分类*/
    @GetMapping("/selectAll")
    public  ResultModel selectAll(){
        Map<String,Object> result=new HashMap<>();
        List<Category> categories = categoryService.selectAll();
        int flag=0;
        if(categories.size()==0){
            flag=1;
        }
        result.put("data",categories);
        return ResultTools.result(flag,"",result);
    }

    //获取该系统下的所有区域
    @GetMapping("/getArea")
    public pageResult count(){
        pageResult pageResult = categoryService.selectByName("贺州语言处理系统");
        return pageResult;
    }

    //获取各区域下的所有语种及种数
    @GetMapping("/category")
    public Map<String,Object> wuzhou(String name){
        Map<String,Object> result=new HashMap<>();
        pageResult pageResult = categoryService.selectByName(name);
        result.put("data",pageResult);
        return result;
    }



}