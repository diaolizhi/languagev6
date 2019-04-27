package com.hzxy.show.service.impl;

        import com.hzxy.domain.entity.Category;
        import com.hzxy.domain.utils.pageResult;
        import com.hzxy.show.dao.CategoryDao;
        import com.hzxy.show.service.CategoryService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }


    @Override
    public pageResult selectByName(String name) {
        List<Category> categories=categoryDao.selectByName(name);
        pageResult page=new pageResult();
        page.setTotal(categories.size());
        page.setData(categories);
        return page;
    }

}
