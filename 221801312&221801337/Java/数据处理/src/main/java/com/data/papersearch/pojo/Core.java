package com.data.papersearch.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Core {
	PaperAdapter pa;
	String path;
	String meetName;
	public Core(String path,String meetName,PaperAdapter pa){
		this.pa=pa;
		this.meetName=meetName;
		this.path=path;
	}

	public void saveToDatabase() throws IOException {
		File dir = new File(path);
		File[] files = dir.listFiles();
		final ArrayList<Paper> papers = new ArrayList<>();
		for (File file : files) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			Scanner scanner = new Scanner(br);
			char c[]=new char[1024];
			StringBuilder sb = new StringBuilder();
			while(scanner.hasNextLine()){
				sb.append(scanner.nextLine());
			}
			br.close();
			if(sb.charAt(sb.length()-1)==';')
				sb=sb.replace(sb.length()-1,sb.length(),"");

			JSONObject jo = JSON.parseObject(sb.toString());
			papers.add(pa.toPaper(jo,meetName,file));
		}
		System.out.println(papers.size());
	}
	public PaperAdapter getPa() {
		return pa;
	}

	public void setPa(PaperAdapter pa) {
		this.pa = pa;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMeetName() {
		return meetName;
	}

	public void setMeetName(String meetName) {
		this.meetName = meetName;
	}
}
