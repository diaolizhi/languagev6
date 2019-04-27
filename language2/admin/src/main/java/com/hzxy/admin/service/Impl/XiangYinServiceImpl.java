package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.XiangYinDao;
import com.hzxy.admin.service.XiangYinService;
import com.hzxy.domain.entity.XiangYin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiangYinServiceImpl implements XiangYinService {
    @Autowired
    private XiangYinDao xiangYinDao;


    /*新增记录*/
    @Override
    public int add(XiangYin entity) {
           if(entity.getId()==null){
             entity.setCreated(new Date());
             entity.setUpdated(new Date());
           }
        return xiangYinDao.insert(entity);
    }

    /*查询所有记录*/
    @Override
    public List<XiangYin> selectAll() {
        return xiangYinDao.selectAll();
    }


    /*查出记录总数*/
    @Override
    public int count(XiangYin entity) {
        return xiangYinDao.count(entity);
    }

    /*根据ID查找记录*/
    @Override
    public XiangYin selectById(Long id) {
        return xiangYinDao.selectById(id);
    }

    /*更新记录*/
    @Override
    public int update(XiangYin entity) {
        if(entity.getId()!=null){
            entity.setUpdated(new Date());
        }
        return xiangYinDao.update(entity);
    }


    /*根据ID删除记录*/
    @Override
    public int deleteById(Long id) {
        return xiangYinDao.deleteById(id);
    }


    /*批量删除*/
    @Override
    public long deleteByList(String ids) {
        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
            xiangYinDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;
    }

}
