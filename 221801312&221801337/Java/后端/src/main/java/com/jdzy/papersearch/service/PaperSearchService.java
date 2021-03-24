package com.jdzy.papersearch.service;

import com.jdzy.papersearch.dao.KeywordDao;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service
public class PaperSearchService {
	@Autowired
	KeywordDao kDao;
	@Autowired
	PaperSearchService service;

	public List<String> searchSimilarWord(String word,Integer limit){
		if(limit==null){
			limit=5;
		}

		String[] split = word.split(" |\\+");
		HashSet<String> set = new LinkedHashSet<>();
		List<String> similarKeyword = kDao.findSimilarKeyword(word,limit);
		set.addAll(kDao.findSimilarKeyword(word,limit));
		for (String s : split) {
			if(set.size()>=limit){
				break;
			}
			set.addAll(kDao.findSimilarKeyword(s,limit));
		}
		List<String> strings = new ArrayList<>(set);

		limit=Math.min(limit,strings.size());
		return strings.subList(0,limit);
	}

	private List<Object> searchPaper(List<Object> searchWord,Integer orderBy,Integer time,Integer from,Integer limit,Integer page){

		return null;
	}
	private List<Object> searchPaper(String searchWord,Integer orderBy,Integer time,Integer from,Integer limit,Integer page){
	    return searchPaper(Collections.singletonList(searchWord),
				orderBy,
				time,
				from,
				limit,
				page);
	}
	@Cacheable(value = "redisCache",
			key="'paper_'+#searchWord+'_'+#orderBy+'_'+#time+'_'+#from+'_'+#page")
	public List<Object> searchPaper(String searchWord,Object orderBy,Object time,Object from,Object limit,Object page){
		return searchPaper(searchWord,
				(Integer)orderBy,
				(Integer)time,
				(Integer)from,
				(Integer)limit,
				(Integer)page);
	}
	public List<Object> searchPaper(List<Object> searchWord,Object orderBy,Object time,Object from,Object limit,Object page){
		return service.searchPaper(searchWord,
				(Integer)orderBy,
				(Integer)time,
				(Integer)from,
				(Integer)limit,
				(Integer)page);
	}

}
