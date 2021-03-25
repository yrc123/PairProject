package com.jdzy.papersearch.dao;

import org.apache.ibatis.annotations.Mapper;

import java.lang.management.MemoryPoolMXBean;
import java.util.List;
import java.util.Map;

@Mapper
public interface MeetDao {
    List<Map<String, Object>> getMeetList();
}
