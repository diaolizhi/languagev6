package com.hzxy.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:lwq
 * @Date:2019/3/2
 * @Description:com.hzxy.admin.web.controller
 * @version:1.0
 */
@Controller
public class CommonConotroller {

    @RequestMapping("/fail")
    public String fail(){
        return "no_resource";
    }

}
