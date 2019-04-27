package com.hzxy.admin.web.controller;

import com.hzxy.admin.service.NewService;
import com.hzxy.domain.entity.AreaContent;
import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingEnumeration;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:lwq
 * @Date:2019/4/1
 * @Description:com.hzxy.admin.web.controller
 * @version:1.0
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewService newService;

    @ModelAttribute
    public News getNewsbyId(Long id){
        News news=new News();
        if(id!=null){
            news = newService.selectById(id);
        }
        else{
            news=new News();
        }
        return news;

    }




    ///获取所有记录
    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> list() throws ParseException {
        Map<String,Object> resulst=new HashMap<>();
        List<News> news = newService.selectAll();
        resulst.put("data",news);
        return resulst;
    }

    //跳转列表
    @GetMapping("/newsList")
    private  String contenLists(){
        return "news_list";
    }


    //跳转列表
    @GetMapping("/newsform")
    private  String newsform(){
        return "news_form";
    }


    //批量删除
    @RequestMapping("/deleteNewsList")
    @ResponseBody
    public Map<String,Object>  deleteByTrap(String ids){
        Map<String,Object> result=new HashMap<>();
        long count = newService.deleteByList(ids);
        if(count>0){
            result.put("msg","成功删除"+count+"记录！");

        }else{
            result.put("msg","删除失败，请稍后再试！");
        }

        return result;
    }




    //单条删除
    @GetMapping("/deleteById")
    public String deleteById(long id){
        newService.deleteById(id);
        return "redirect:/news/newsList";

    }


    //根据id获取信息
    @ResponseBody
    @GetMapping("/selectById")
    public News selectById(long id){
        return   newService.selectById(id);

    }


    //新增内容
    @PostMapping("/save")
    public String addContent(News news,Model model){
        if(news.getId()==null){
            int add = newService.add(news);
            if(add!=0){
                model.addAttribute("msg","新增内容成功！");
            }else
            {
                model.addAttribute("msg","新增内容失败！");
                return "redirect:/content/content_form";

            }
        }else{
            newService.update(news);
        }


        return "redirect:/news/newsList";
    }


}
