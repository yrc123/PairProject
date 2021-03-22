package com.jdzy.papersearch.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class KeywordDaoTest {
	@Autowired
	KeywordDao dao;

	@Test
	void findKeywordIdByName() {
		Assert.assertEquals(Integer.valueOf(1),dao.findKeywordIdByName("Mirrors"));
		Assert.assertEquals(Integer.valueOf(12752),dao.findKeywordIdByName("Vision for graphics"));
	}

	@Test
	void findTopKeyword() throws ParseException {
		List<Map<String, String>> topKeyword = dao.findTopKeyword(1, new SimpleDateFormat("yyyy").parse("2001"));
		Assert.assertEquals(10,topKeyword.size());
		Assert.assertEquals(44L,topKeyword.get(0).get("keyword_num"));
	}
}