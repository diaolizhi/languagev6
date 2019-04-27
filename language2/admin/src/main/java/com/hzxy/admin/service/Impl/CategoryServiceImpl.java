package com.hzxy.admin.service.Impl;

import com.hzxy.admin.abstract1.AbstractBaseTreeServiceImpl;
import com.hzxy.admin.dao.CategoryDao;
import com.hzxy.admin.service.AreaContentService;
import com.hzxy.admin.service.CategoryService;
import com.hzxy.domain.entity.Category;
import com.hzxy.domain.utils.BaseResult;
import com.hzxy.domain.utils.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/3/5
 * @Description:com.hzxy.admin.service.Impl
 * @version:1.0
 */
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl extends AbstractBaseTreeServiceImpl<Category,CategoryDao> implements CategoryService {

    @Autowired
    private AreaContentService areaContentService;

    /**
     * 保存分类
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(readOnly = false)
    public BaseResult save(Category entity) {
           Category parent = entity.getParent();
            // 如果没有选择父级节点则默认设置为根目录
            if (parent == null || parent.getId() == null) {
                // 0 代表根目录
                parent.setId(0L);
            }

            entity.setUpdated(new Date());
            // 新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                // 判断当前新增的节点有没有父级节点
                if (parent.getId() != 0L) {
                    Category currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        // 为父级节点设置 isParent 为 true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);
                    }
                }

                // 父级节点为 0 ，表示为根目录
                else {
                    // 根目录一定是父级目录
                    entity.setIsParent(true);
                }

                dao.insert(entity);
            }

            // 修改
            else {
                update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }

    /**
     * 删除分类
     *
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        List<String> targetArray = new ArrayList<>();
        findAllChild(targetArray, id);

        String[] categoryIds = targetArray.toArray(new String[targetArray.size()]);

        // 删除类目及其子类目
        dao.delete(categoryIds);

        // 删除类目下所有内容
        areaContentService.deleteByCategoryId(categoryIds);
    }

    /**
     * 查找出所有子节点
     *
     * @param targetList
     * @param parentId
     */
    private void findAllChild(List<String> targetList, Long parentId) {
        targetList.add(String.valueOf(parentId));

        List<Category> tbContentCategories = selectByPid(parentId);
        for (Category tbContentCategory : tbContentCategories) {
            findAllChild(targetList, tbContentCategory.getId());
        }
    }
}
