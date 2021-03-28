package com.jdzy.papersearch.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.jdzy.papersearch.pojo.Keyword;
import com.jdzy.papersearch.service.PaperSearchService;
import com.jdzy.papersearch.tools.HttpTools;
import com.jdzy.papersearch.tools.OpenApiTools;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PaperSearchController {

	@Autowired
	PaperSearchService searchService;

	@PostMapping(value = "/search_word")
	@ResponseBody
	public Map<String,Object> searchWord(@Schema(defaultValue = OpenApiTools.searchWord)
											 @RequestBody Map<String,Object> req,
										 HttpServletRequest http){
		List<Keyword> searchWord = searchService.searchSimilarWord((String) req.get("searchWord"),(Integer) req.getOrDefault("limit",null));

		HashMap<String, Object> resp = new LinkedHashMap<>();
		resp.put("searchWord",searchWord);
		return resp;
	}
	@PostMapping("/search_paper")
	@ResponseBody
	public Map<String,Object> searchPaper(@Schema(defaultValue = OpenApiTools.searchPaper)
											  @RequestBody Map<String,Object> req,
										  HttpServletRequest http){
		HashMap<String, Object> resp = new LinkedHashMap<>();

		List<Map<String,Object>>paperList=searchService.searchPaper((String)req.get("searchWord"),
				(Integer)req.get("orderBy"),
				(Integer)req.get("time"),
				(Integer)req.get("meetId"),
				(Integer)req.get("limit"),
				(Integer)req.get("page"));
		resp.put("paperList",paperList);
		return resp;
	}

}
