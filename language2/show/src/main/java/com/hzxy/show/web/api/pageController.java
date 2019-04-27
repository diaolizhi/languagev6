package com.hzxy.show.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther:lwq
 * @Date:2019/3/8
 * @Description:com.hzxy.show.web.api
 * @version:1.0
 */
@Controller
public class pageController {

    //显示各区域下的语种

    @RequestMapping("/category/{page1}")
    public String category(@PathVariable String  page1,Model model){
        model.addAttribute("areName",page1);
        return "/page";
    }

    @RequestMapping("/page")
    public String page(){

        return "page";
    }


    //显示各语种下的内容
    @RequestMapping("/language/{name}")
    public String content(@PathVariable String  name,Model model){
        model.addAttribute("language",name);
        return "/content";
    }

    @RequestMapping("/content")
    public String content(){

        return "content";
    }


    //显示视频
    @RequestMapping("/content/{name}/video")
    public String video(@PathVariable String  name,Model model){
        model.addAttribute("language",name);
        return "video";
    }



}
