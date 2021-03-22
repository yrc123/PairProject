package com.data.papersearch;

import com.data.papersearch.dao.PaperDao;
import com.data.papersearch.service.Core;
import com.data.papersearch.pojo.Paper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.*;

@SpringBootApplication()
@PropertySource(value={"application-local.properties"})

public class PapersearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(PapersearchApplication.class, args);

	}
	@Bean(name = "iccv")
	public Core getIccv(){
		return new Core("./论文数据/ICCV", "ICCV", Paper.getDefultPaperAdapter());
	}
	@Bean(name = "cvpr")
	public Core getCvpr(){
		return new Core("./论文数据/CVPR", "CVPR", Paper.getDefultPaperAdapter());
	}
	@Bean(name = "eccv")
	public Core getEccv(){
		return new Core("./论文数据/ECCV", "ECCV", Paper.getECCVPaperAdapter());
	}
	@Bean(name="test")
	public Core getTest(){
		return new Core("./论文数据/ICCV_test", "ICCV", Paper.getDefultPaperAdapter());
	}
	@Autowired
	Core iccv;
	@Autowired
	Core cvpr;
	@Autowired
	Core eccv;
	@Autowired
	Core test;
	@PostConstruct
	public void init() throws IOException {
		iccv.start();
		cvpr.start();
		eccv.start();

//		int maxa=0;
//		int maxk=0;
//		for (Paper paper : eccv.getPapers()) {
//			maxa=Math.max(maxa,paper.getAbstract().length());
//			for (String keyword : paper.getKeywords()) {
//				maxk=Math.max(maxk,keyword.length());
//			}
//		}
//		for (Paper paper : iccv.getPapers()) {
//				maxa=Math.max(maxa,paper.getAbstract().length());
//			for (String keyword : paper.getKeywords()) {
//				maxk=Math.max(maxk,keyword.length());
//			}
//		}
//		for (Paper paper : cvpr.getPapers()) {
//			maxa=Math.max(maxa,paper.getAbstract().length());
//			for (String keyword : paper.getKeywords()) {
//				maxk=Math.max(maxk,keyword.length());
//			}
//		}
//		System.out.println("maxa: "+maxa+"\nmaxk:"+maxk);
//		eccv.saveToDatabase();
	}

}
