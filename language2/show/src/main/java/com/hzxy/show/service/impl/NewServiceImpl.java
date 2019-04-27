package com.hzxy.show.service.impl;

import com.github.pagehelper.PageHelper;
import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;
import com.hzxy.show.dao.NewsDao;
import com.hzxy.show.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/4/4
 * @Description:com.hzxy.show.service.impl
 * @version:1.0
 */
@Service
public class NewServiceImpl implements NewService{
    @Autowired
    private NewsDao newsDao;

    @Override
    public PageInfo<News> findItemByPage(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);

        List<News> allItems = newsDao.findAll();        //全部商品
        int countNums = newsDao.count();           //总记录数
        PageInfo<News> pageData = new PageInfo<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
        return pageData;

    }

    @Override
    public News selectById(Long Id) {
        return newsDao.selectById(Id);
    }


}
