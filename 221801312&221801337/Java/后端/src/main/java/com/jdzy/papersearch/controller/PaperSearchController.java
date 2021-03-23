package com.jdzy.papersearch.controller;

import com.jdzy.papersearch.service.PaperSearchService;
import com.jdzy.papersearch.tools.HttpTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PaperSearchController {

	@Autowired
	PaperSearchService searchService;

	@PostMapping("/api/search-word")
	@ResponseBody
	public Map<String,Object> searchWord(@RequestBody Map<String,Object> req){
		req=(Map)req.get("data");
		List<String> searchWord = searchService.searchSimilarWord((String) req.get("searchWord"),(Integer) req.getOrDefault("limit",null));

		HashMap<String, Object> resp = new HashMap<>();
		resp.put("searchWord",searchWord);
		return HttpTools.buildResp(resp);
	}
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello";
	}

}
