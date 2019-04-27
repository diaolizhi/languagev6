package com.hzxy.show.dao;

import com.hzxy.domain.entity.AreaContent;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface ConentDao {

    //查询所有内容信息
     List<AreaContent> selectAll(String name);


}
