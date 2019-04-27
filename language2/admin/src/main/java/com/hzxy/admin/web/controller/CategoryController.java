package com.hzxy.admin.web.controller;

import com.hzxy.admin.abstract1.AbstractBaseTreeController;
import com.hzxy.admin.service.CategoryService;
import com.hzxy.domain.entity.Category;
import com.hzxy.domain.utils.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 内容分类管理
 * <p>Title: ContentCategoryController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/6/25 9:17
 */
@Controller
@RequestMapping(value = "/content/category")
public class CategoryController extends AbstractBaseTreeController<Category, CategoryService> {

    @ModelAttribute
    public Category getTbContentCategory(Long id) {
       Category tbContentCategory = null;

        // id 不为空，则从数据库获取
        if (id != null) {
            tbContentCategory = service.getById(id);
        } else {
            tbContentCategory = new Category();
        }

        return tbContentCategory;
    }

    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Category> targetList = new ArrayList<>();
        List<Category> sourceList = service.selectAll();

        // 排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("categories", targetList);
        return "category_list";
    }

    protected void sortList(  List<Category> sourceList,   List<Category> targetList, Long parentId) {
        for (Category sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                // 判断有没有子节点，如果有则继续追加
                if (sourceEntity.getIsParent()) {
                    for (Category currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList, targetList, sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 跳转表单页
     *
     * @return
     */
    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Category Category) {
        return "next_category_form";
    }

    /**
     * 保存
     *
     * @param category
     * @return
     */
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Category category, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(category);

        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        } else {
            model.addAttribute("baseResult", baseResult);
            return form(category);
        }
    }



    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            service.delete(Long.parseLong(ids));
            baseResult = BaseResult.success("删除分类及其子类及其全部内容成功");
        } else {
            baseResult = BaseResult.fail("删除分类失败");
        }

        return baseResult;
    }

    /**
     * 树形结构
     *
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    public List<Category> treeData(Long id) {
        if (id == null) {
            id = 0L;
        }
        return service.selectByPid(id);
    }




    @RequestMapping(value = "list1", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list1() {
        Map<String,Object> result=new HashMap<>();
        List<Category> targetList = new ArrayList<>();
        List<Category> sourceList = service.selectAll();

        // 排序
        sortList(sourceList, targetList, 0L);
        result.put("data",sourceList);

        return result;
    }
}
