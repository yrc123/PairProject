package com.jdzy.papersearch.service;

import com.jdzy.papersearch.dao.KeywordDao;
import com.jdzy.papersearch.dao.PaperDao;
import com.jdzy.papersearch.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Cacheable(value="top10",
            key = "'data'")
    public Map<String,Object> getTop10(){
        List<Map<String, Object>> topKeyword = kDao.findTopKeyword(null, null,10);
        HashMap<String, Object> resp = new HashMap<>();
        List<Integer> id = new ArrayList<>();
        List<String> name = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        List<List<Paper>> papers = new ArrayList<>();
        resp.put("keywordId",id);
        resp.put("keywordName",name);
        resp.put("keywordNum",num);
        resp.put("paperList",papers);
        for (Map<String, Object> word : topKeyword) {
            id.add(Integer.valueOf((Integer)word.get("keyword_id")));
            name.add((String)word.get("keyword_name"));
            num.add(((Long)word.get("keyword_num")).intValue());
            List<Paper> paper = pDao.findPaperByKeywordId((Integer) word.get("keyword_id"), null, null, 10);
            papers.add(paper);
        }
        return resp;
    }
}
