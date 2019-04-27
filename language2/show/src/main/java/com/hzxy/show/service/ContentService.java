package com.hzxy.show.service;

import com.hzxy.domain.entity.AreaContent;
import com.hzxy.domain.utils.contentResult;

import java.util.List;

public interface ContentService {
    //查询所有内容信息
   contentResult selectAll(String name);

}