package com.jdzy.papersearch.controller;

import com.jdzy.papersearch.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class EchartController {
    @Autowired
    EchartsService eService;

    @PostMapping("/top10")
    @ResponseBody
    public Map<String,Object> getTop10(@RequestBody Map<String,Object> req, HttpServletRequest http){
        return eService.getTop10();
    }

}
