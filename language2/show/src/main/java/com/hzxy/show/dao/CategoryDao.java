package com.hzxy.show.dao;

import com.hzxy.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao {
    /*查看所有分类*/
    List<Category> selectAll();

    List<Category> selectByName(String name);
}
