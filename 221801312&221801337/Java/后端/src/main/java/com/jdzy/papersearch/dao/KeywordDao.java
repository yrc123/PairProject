package com.jdzy.papersearch.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface KeywordDao {
	Integer findKeywordIdByName(String keyword);
	List<Map<String,String>> findTopKeyword(int meetId, Date publicationYear);
	List<String> findSimilarKeyword(String keyword,Integer limit);

}
