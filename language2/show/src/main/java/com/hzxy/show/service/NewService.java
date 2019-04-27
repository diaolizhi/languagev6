package com.hzxy.show.service;

import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;

import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/4/4
 * @Description:com.hzxy.show.service
 * @version:1.0
 */
public interface NewService {
    /**
     * 分页查询数据
     * @return
     */
    public PageInfo<News>  findItemByPage(int currentPage, int pageSize);

    //根据id查找记录
    News selectById(Long Id);


}
