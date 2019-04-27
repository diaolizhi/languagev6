package com.hzxy.show.web.api;

import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;
import com.hzxy.show.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/4/4
 * @Description:com.hzxy.show.web.api
 * @version:1.0
 */
@RestController
@RequestMapping("/show/news")
public class NewsController {

    @Autowired
    private NewService newService;


    @GetMapping("/itemsPage")
    @ResponseBody
     public PageInfo<News> itemsPage(@RequestParam(defaultValue = "1")int currentPage, @RequestParam(defaultValue = "10") int pageSize){
                return newService.findItemByPage(currentPage, pageSize);
      }


      @GetMapping("/selectById")
      @ResponseBody
      public News selectById(Long id){
          return newService.selectById(id);
      }
}
