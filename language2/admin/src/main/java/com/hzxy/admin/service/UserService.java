package com.hzxy.admin.service;

import com.hzxy.admin.base.BaseService;
import com.hzxy.domain.entity.User;
import java.util.List;

public interface UserService extends BaseService<User> {



    User login(String username, String password);

    //重置密码
  int reset(User user);

    User selectByforget(String reset);


}
