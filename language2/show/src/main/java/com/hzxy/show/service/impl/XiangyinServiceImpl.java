package com.hzxy.show.service.impl;

import com.github.pagehelper.PageHelper;
import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;
import com.hzxy.domain.entity.XiangYin;
import com.hzxy.show.dao.XiangyinDao;
import com.hzxy.show.service.XiangyinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiangyinServiceImpl implements XiangyinService {

    @Autowired
    private XiangyinDao xiangyinDao;

    /*新增*/
    @Override
    public int insert(XiangYin xiangyin) {
        if(xiangyin.getId()==null){
            xiangyin.setCreated(new Date());
            xiangyin.setUpdated(new Date());
        }
        return xiangyinDao.insert(xiangyin);
    }

    /*根据类型查找*/
    @Override
    public List<XiangYin> selectByType(String type) {
        return xiangyinDao.selectByType(type);
    }

    /*
    * 根据id查找*/
    @Override
    public XiangYin selectById(Long id) {
        return  xiangyinDao.selectById(id);
    }


    /*查询分页并排序*/
    @Override
    public PageInfo<XiangYin> findItemByPage(int currentPage, int pageSize,String name) {
        PageHelper.startPage(currentPage, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        List<XiangYin> allItems = xiangyinDao.selectAll(map);        //全部
        int countNums = xiangyinDao.count(map);
        //总记录数
        PageInfo<XiangYin> pageData = new PageInfo<>(currentPage, pageSize, countNums);
        pageData.setItems(allItems);
       return pageData;
    }


}
