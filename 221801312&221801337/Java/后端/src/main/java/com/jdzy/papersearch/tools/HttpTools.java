package com.jdzy.papersearch.tools;

import java.util.HashMap;
import java.util.Map;

public class HttpTools {
	public static Map<String,Object> buildResp(Object o){
		final HashMap<String, Object> resp = new HashMap<>();
		resp.put("data",o);
		return resp;
	}

}
