package com.hzxy.admin.service;

import com.hzxy.admin.base.BaseService;
import com.hzxy.domain.entity.AreaContent;
public interface AreaContentService extends BaseService<AreaContent> {

    /**
     * 根据类目 ID 删除内容
     * @param categoryIds
     */
    void deleteByCategoryId(String[] categoryIds);

}
