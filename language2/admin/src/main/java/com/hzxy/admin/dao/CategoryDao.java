package com.hzxy.admin.dao;

import com.hzxy.admin.base.BaseDao;
import com.hzxy.admin.base.BaseTreeDao;
import com.hzxy.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends BaseTreeDao<Category> {

}
