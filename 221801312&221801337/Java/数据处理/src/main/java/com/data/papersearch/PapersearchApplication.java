package com.data.papersearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.papersearch.pojo.Core;
import com.data.papersearch.pojo.Paper;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
		eccv.saveToDatabase();
	}

}
