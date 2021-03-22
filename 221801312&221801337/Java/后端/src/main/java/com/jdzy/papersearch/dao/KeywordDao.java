package com.jdzy.papersearch.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface KeywordDao {
	public Integer findKeywordIdByName(String keyword);
	public List<Map<String,String>> findTopKeyword(int meetId, Date publicationYear);
}
