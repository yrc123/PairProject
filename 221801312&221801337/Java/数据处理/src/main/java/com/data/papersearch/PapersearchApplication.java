package com.data.papersearch;

import com.data.papersearch.service.Core;
import com.data.papersearch.pojo.Paper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.io.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PapersearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapersearchApplication.class, args);

	}
	@PostConstruct
	public void init() throws IOException {
		Core iccv = new Core("./论文数据/ICCV", "ICCV", Paper.getDefultPaperAdapter());
		Core cvpr = new Core("./论文数据/CVPR", "CVPR", Paper.getDefultPaperAdapter());
		Core eccv = new Core("./论文数据/ECCV", "ECCV", Paper.getECCVPaperAdapter());
		Core test = new Core("./论文数据/ICCV_test", "ICCV", Paper.getDefultPaperAdapter());
//		eccv.saveToDatabase();
		test.start();
	}

}
