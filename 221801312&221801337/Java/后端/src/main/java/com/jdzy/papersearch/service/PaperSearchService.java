package com.jdzy.papersearch.service;

import com.jdzy.papersearch.dao.KeywordDao;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class PaperSearchService {
	@Autowired
	KeywordDao kDao;

	public List<String> searchSimilarWord(String word,Integer limit){
		if(limit==null){
			limit=5;
		}

		String[] split = word.split(" |\\+");
		HashSet<String> set = new HashSet<>();
		for (String s : split) {
			List<String> keywords = kDao.findSimilarKeyword(s,limit);
			for (String keyword : keywords) {
				set.add(keyword);
			}
		}
		List<String> strings = new ArrayList<>(set);

		limit=Math.min(limit,strings.size());
		return strings.subList(0,limit);
	}
}
