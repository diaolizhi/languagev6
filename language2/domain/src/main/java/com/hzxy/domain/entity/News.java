package com.hzxy.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther:lwq
 * @Date:2019/4/1
 * @Description:com.hzxy.domain.entity
 * @version:1.0
 */
@Data
public class News implements Serializable {
    private Long id;
    private String ftitle;
    private String stitle;
    private String content;
    private Date created;
    private Date updated;

}
