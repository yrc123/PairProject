package com.jdzy.papersearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class EchartController {
    @RequestMapping("Top10")
    @ResponseBody
    public Map<String,Object> getTop10(@RequestBody Map<String,Object> req, HttpServletRequest http){
        HashMap<String, Object> resp = new HashMap<>();

        return resp;
    }

}
