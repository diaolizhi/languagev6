package com.hzxy.show.service;


import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;
import com.hzxy.domain.entity.XiangYin;

import java.util.List;

public interface XiangyinService {
    //新增
    int insert(XiangYin xiangyin);

    //跟据类型查询记录
    List<XiangYin> selectByType(String type);

    //根据Id查询记录
    XiangYin selectById(Long id);

    /**
     * 分页查询数据
     * @return
     */
    public PageInfo<XiangYin> findItemByPage(int currentPage, int pageSize,String name);

}
