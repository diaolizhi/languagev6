package com.hzxy.show.dao;

import com.hzxy.domain.entity.XiangYin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface XiangyinDao {

    //新增
    int insert(XiangYin xiangyin);

    //展示所有信息
    List<XiangYin> selectAll(Map<String,Object> map);

    //记录数
    Integer count(Map<String,Object> map);


    //跟据类型查询记录
    List<XiangYin> selectByType(String type);

    //根据Id查询记录
    XiangYin selectById(Long id);



}
