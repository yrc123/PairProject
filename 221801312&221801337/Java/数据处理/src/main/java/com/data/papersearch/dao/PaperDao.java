package com.data.papersearch.dao;

import com.data.papersearch.pojo.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperDao {
	public int getKeywordCount(String keyword);
	public int getAuthorCount(String keyword);
	public int getMeetCount(String keyword);
	public int insertKeyword(String keyword);
	public int insertMeet(String keyword);
	public int insertAuthor(String keyword);
	public int insertPaper(Object... o);
	public int findMeetIdByName(String name);
	public int findAuthorIdByName(String name);
	public int findPaperIdByName(String name);
	public int findKeywordIdByName(String name);

	public int insertPaperAuthor(int paperId, int authorId);
	public int insertPaperKeyword(int paperId, int keywordId);

}
