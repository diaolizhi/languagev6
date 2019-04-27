package com.hzxy.admin.dao;

import com.hzxy.admin.base.BaseDao;
import com.hzxy.domain.entity.AreaContent;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaContentDao extends BaseDao<AreaContent> {
    /**
     * 根据类目 ID 删除内容
     *
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);


}

