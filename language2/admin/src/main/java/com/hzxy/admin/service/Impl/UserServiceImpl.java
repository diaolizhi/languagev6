package com.hzxy.admin.service.Impl;

import com.hzxy.admin.dao.UserDao;
import com.hzxy.admin.service.UserService;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public int add(User entity) {
        return 0;
    }

    /**
     * 用户列表
     */
    @Override
    public List<User> selectAll() {
        //pageHeler帮我们生成分页语句
        List<User> users=userDao.selectAll();
        return users;

    }

    @Override
    public int count(User entity) {
        return 0;
    }


    @Override
    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public int  update(User user) {
         user.setUpdated(new Date());
        return userDao.update(user);
    }

    @Override
    public int deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public long deleteByList(String ids) {
        String[] ss = ids.split(",");
        long count= 0;
        for (String s : ss) {
            userDao.deleteByTrap(Integer.parseInt(s));
            count++;
        }
        return count;
    }



    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public int reset(User user) {
        return userDao.reset(user);
    }

    @Override
    public User selectByforget(String reset) {
        return userDao.selectByforget(reset);
    }


}
