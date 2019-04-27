package com.hzxy.admin.dao;

import com.hzxy.admin.base.BaseDao;
import com.hzxy.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<User> {
    //用户登录
    User login(@Param("username") String username, @Param("password") String password);

    //重置密码
    //重置密码
  int reset(User user);

   User selectByforget(String reset);
}
