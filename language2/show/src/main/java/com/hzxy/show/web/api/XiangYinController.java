package com.hzxy.show.web.api;


import com.hzxy.domain.entity.News;
import com.hzxy.domain.entity.PageInfo;
import com.hzxy.domain.entity.XiangYin;
import com.hzxy.domain.utils.ResultModel;
import com.hzxy.domain.utils.ResultTools;
import com.hzxy.show.service.XiangyinService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:lwq
 * @Date:2019/2/4
 * @Description:com.hzxy.show.web.api
 * @version:1.0
 */
@RestController
@RequestMapping("/show/xiangyin")
public class XiangYinController {

    @Autowired
    private XiangyinService xiangyinService;

    /*增加乡音记录*/
    @PostMapping("/add")
    private Map<String,Object>  add(XiangYin  xiangYin){
       Map<String,Object> result=new HashMap<>();
       int insert = xiangyinService.insert(xiangYin);
       if(insert==0){
           result.put("err",1);
           result.put("message","新增失败!");
       }else{
           result.put("err",0);
           result.put("message","新增成功!");
       }

        return result;

    }




    @GetMapping("/itemsPage")
    @ResponseBody
    public PageInfo<XiangYin> itemsPage(@RequestParam(defaultValue = "1",required = false)int currentPage, @RequestParam(defaultValue = "10",required = false) int pageSize,String name){
        return xiangyinService.findItemByPage(currentPage, pageSize,name);
    }


    /*根据 乡音类型查找相应的记录*/
    @GetMapping("/selectType")
    public ResultModel  selectbyType(String type){
        Map<String,Object> result=new HashMap<>();
        List<XiangYin> xiangYins = xiangyinService.selectByType(type);
        int flag=0;
        if(xiangYins.size()==0){
            flag=1;
        }
        result.put("data",xiangYins);
        return ResultTools.result(flag,"",result);
    }


    /*根据id查询相应的记录*/
    @RequestMapping("/selectById")
    public Map<String,Object>  selectById(Long id){
        Map<String,Object> result=new HashMap<>();
        XiangYin xiangYin = xiangyinService.selectById(id);
        String msg="查找成功！";
        if(xiangYin==null){
           msg="该记录不存在！";
        }
        result.put("msg",msg);
        result.put("data",xiangYin);
        return result;
    }


    }


