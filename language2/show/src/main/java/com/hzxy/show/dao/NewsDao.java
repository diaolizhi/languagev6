package com.hzxy.show.dao;

import com.github.pagehelper.Page;
import com.hzxy.domain.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/4/4
 * @Description:com.hzxy.show.dao
 * @version:1.0
 */
@Repository
public interface NewsDao {

    /**
     * 分页数据
     * @return
     */
   List<News> findAll();


   //查询总记录数
    Integer count();

    //根据id查找记录
    News selectById(Long Id);
}
