package com.jdzy.papersearch.dao;

import com.jdzy.papersearch.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface PaperDao {
	 List<Paper> findPaperByKeyword(int keywordId, Date publicationYear, int meetId);
}
