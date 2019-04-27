package com.hzxy.admin.abstract1;

import com.hzxy.admin.base.BaseTreeService;
import com.hzxy.domain.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public abstract class AbstractBaseTreeController<T , S extends BaseTreeService<T>> {
    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页
     *
     * @return
     */
    public abstract String form(T entity);

    /**
     * 保存
     *
     * @param entity
     * @param model
     * @param redirectAttributes
     * @return
     */
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    /**
     * 删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 树形结构
     *
     * @param id
     * @return
     */
    public abstract List<T> treeData(Long id);

}
