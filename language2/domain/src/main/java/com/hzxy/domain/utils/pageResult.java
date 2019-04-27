package com.hzxy.domain.utils;

import com.hzxy.domain.entity.Category;
import lombok.Data;

import java.util.List;

/**
 * @Auther:lwq
 * @Date:2019/3/6
 * @Description:com.hzxy.domain.utils
 * @version:1.0
 */
@Data
public class pageResult{
    private   Integer total;
   private   List<Category>  data;
}
