package com.hzxy.domain.utils;

import com.hzxy.domain.entity.AreaContent;
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
public class contentResult {
    private   Integer total; //内容的条数
    private   Integer pictotal;//图片真实存在的数目
    private  Integer videoTotal;//视频真实存在的数目
    private   List<AreaContent>  data;
}
