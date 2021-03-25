package com.jdzy.papersearch.controller;

import com.jdzy.papersearch.service.PaperSearchService;
import com.jdzy.papersearch.tools.HttpTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PaperSearchController {

	@Autowired
	PaperSearchService searchService;

	@PostMapping("/search_word")
	@ResponseBody
	public Map<String,Object> searchWord(@RequestBody Map<String,Object> req, HttpServletRequest http){
		List<String> searchWord = searchService.searchSimilarWord((String) req.get("searchWord"),(Integer) req.getOrDefault("limit",null));

		HashMap<String, Object> resp = new LinkedHashMap<>();
		resp.put("searchWord",searchWord);
		return resp;
	}
	@PostMapping("/search_paper")
	@ResponseBody
	public Map<String,Object> searchPaper(@RequestBody Map<String,Object> req,  HttpServletRequest http){
		HashMap<String, Object> resp = new LinkedHashMap<>();

		List<Object>paperList=searchService.searchPaper((String)req.get("searchWord"),
				(Integer)req.get("orderBy"),
				(Integer) req.get("time"),
				(Integer)req.get("from"),
				(Integer)req.get("limit"),
				(Integer)req.get("page"));
		resp.put("paperList",paperList);
		return resp;
	}

}
