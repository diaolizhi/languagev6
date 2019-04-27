package com.hzxy.show.service.impl;

import com.hzxy.domain.entity.AreaContent;
import com.hzxy.domain.utils.contentResult;
import com.hzxy.show.dao.ConentDao;
import com.hzxy.show.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ContentServiceImpl implements ContentService {
    @Autowired
    private ConentDao conentDao;
    @Override
    public contentResult selectAll(String name) {
        List<AreaContent> areaContents = conentDao.selectAll(name);
        contentResult contents=new contentResult();
        int pCount=0;
        int vCount=0;
        for(int i=0;i<areaContents.size();i++){
            if(areaContents.get(i).getPic1()!=null&&!(areaContents.get(i).getPic1().equals(""))){
                pCount++;
            }if(areaContents.get(i).getPic2()!=null&&!(areaContents.get(i).getPic2().equals(""))){
                pCount++;
            }if(areaContents.get(i).getPic3()!=null&&!(areaContents.get(i).getPic3().equals(""))){
                pCount++;
            }if(areaContents.get(i).getPic4()!=null&&!(areaContents.get(i).getPic4().equals(""))){
                pCount++;
            }
            if(areaContents.get(i).getVideo1()!=null&&!(areaContents.get(i).getVideo1().equals(""))){
               vCount++;
            }
            if(areaContents.get(i).getVideo2()!=null&&!(areaContents.get(i).getVideo2().equals(""))){
                vCount++;
            }
            if(areaContents.get(i).getVideo3()!=null&&!(areaContents.get(i).getVideo3().equals(""))){
               vCount++;
            }if(areaContents.get(i).getVideo4()!=null&&!(areaContents.get(i).getVideo4().equals(""))){
                vCount++;
            }
        }
        contents.setTotal(areaContents.size());
        contents.setPictotal(pCount);
        contents.setVideoTotal(vCount);
        contents.setData(areaContents);
        return contents;
    }


}
