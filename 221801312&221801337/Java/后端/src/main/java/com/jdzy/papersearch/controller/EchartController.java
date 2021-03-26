package com.jdzy.papersearch.controller;

import com.jdzy.papersearch.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class EchartController {
    @Autowired
    EchartsService eService;

    @RequestMapping(value = "/top10",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getTop10(@RequestBody(required = false) Map<String,Object> req, HttpServletRequest http){
        return eService.getTop10();
    }

    @RequestMapping(value = "/sunburst",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> getSunburst(@RequestBody(required = false) Map<String,Object> req, HttpServletRequest http){
        return eService.getSunburst();
    }
}
