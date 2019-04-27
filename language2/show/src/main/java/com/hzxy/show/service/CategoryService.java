package com.hzxy.show.service;

import com.hzxy.domain.entity.Category;
import com.hzxy.domain.utils.pageResult;

import java.util.List;

public interface CategoryService {
    /*查看所有分类*/
    List<Category> selectAll();


    pageResult selectByName(String name);


}
