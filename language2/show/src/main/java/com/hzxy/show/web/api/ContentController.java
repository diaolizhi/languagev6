package com.hzxy.show.web.api;

import com.hzxy.domain.entity.AreaContent;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.hzxy.domain.utils.contentResult;
import com.hzxy.show.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping ("/show/content")
public class ContentController {
    @Autowired
    private ContentService contentService;


    /*返回各语种下的所有内容记录*/
    @GetMapping("/lists")
    private ResultModel lists(String name){
        Map<String,Object> result=new HashMap<>();
        contentResult conts = contentService.selectAll(name);
        int flag=0;
        if(conts.getData().size()==0){
            flag=1;
        }
        result.put("data",conts);
        return ResultTools.result(flag,"",result);
    }


}
