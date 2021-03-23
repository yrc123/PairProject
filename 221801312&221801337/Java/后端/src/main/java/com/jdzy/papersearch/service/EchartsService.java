package com.jdzy.papersearch.service;

import com.jdzy.papersearch.dao.KeywordDao;
import com.jdzy.papersearch.dao.PaperDao;
import com.jdzy.papersearch.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EchartsService {
    @Autowired
    KeywordDao kDao;
    @Autowired
    PaperDao pDao;

    public Map<String,Object> getSunburstData(){
        return null;
    }
    private List<Paper> findPaperByKeyword(){
        return null;
    }
}
