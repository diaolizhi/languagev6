package com.hzxy.domain.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data

public class Category implements Serializable{

    private Long id;
    private Date created;
    private Date updated;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
    private Category parent;

}
