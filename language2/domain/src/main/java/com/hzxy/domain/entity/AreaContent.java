package com.hzxy.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AreaContent implements Serializable {

   private Long id;
   private String yanyu;
   private String geyao;
   private String gushi;
   private String jinji;
   private String qiyu;
   private String dancantuce;
   private String content;
   private String pic1;
   private String pic2;
   private String pic3;
   private String pic4;
   private String video1;
   private String video2;
   private String video3;
   private String video4;
   private Date created;
   private Date updated;
   private Category category;
}