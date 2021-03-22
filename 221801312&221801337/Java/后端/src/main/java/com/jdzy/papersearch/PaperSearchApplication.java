package com.jdzy.papersearch;

import com.jdzy.papersearch.dao.KeywordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@SpringBootApplication
@PropertySource(value="classpath:application-local.properties")
public class PaperSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperSearchApplication.class, args);
	}
//	@Autowired
//	KeywordDao dao;
//	@PostConstruct
//	public void test(){
//		System.out.println(dao.findKeywordIdByName("Mirrors"));
//	}

}
