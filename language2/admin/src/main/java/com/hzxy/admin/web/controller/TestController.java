package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.UserService;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:lwq
 * @Date:2019/3/4
 * @Description:com.hzxy.admin.web
 * @version:1.0
 */
@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/forget")
    public  String page(){
        return "forget";
    }

    @PostMapping("/user/reset")
    public String reset(String forgetp,Model model){
        //重置密码
        User user = userService.selectByforget(forgetp);
        String msg=null;

        if(user==null){
            msg="抱歉，答案有错，请重新输入";
        }else{
            User user1=new User();
            user1.setId(user.getId());
            user1.setUsername(user.getUsername());
            user1.setPhone(user.getPhone());
            user1.setEmail(user.getEmail());
            user1.setUpdated(new Date());
            user1.setPassword("123456");
            int reset = userService.reset(user1);
            msg="密码重置成功！新的密码为："+user1.getPassword();

        }
        model.addAttribute("msg",msg);

        return page();


    }


}
