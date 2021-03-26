package com.jdzy.papersearch.service;

import com.jdzy.papersearch.dao.KeywordDao;
import com.jdzy.papersearch.dao.MeetDao;
import com.jdzy.papersearch.dao.PaperDao;
import com.jdzy.papersearch.pojo.Meet;
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
    @Autowired
    MeetDao mDao;

    @Cacheable(value="sunburst",
            key = "'data'")
    public Map<String,Object> getSunburst(){
        Map<String,Object> res = new HashMap<>();


        List<Meet> meetList = mDao.getMeetList();
        for (Meet meet : meetList) {
            List<Map<String, Object>> keywords = kDao.findTopKeyword((Integer) meet.getId(), null, 10);
            for (Map<String, Object> keywordMap : keywords) {
                keywordMap.put("Papers", pDao.findPaperByKeywordId((Integer) keywordMap.get("keyword_id"),
                        (Integer) meet.getId(),
                        null,
                        10));
            }
            res.put((String) meet.getName(),keywords);
        }
        return res;
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
