package com.jdzy.papersearch.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
class MeetDaoTest {
    @Autowired
    MeetDao dao;
    @Test
    void getMeetList(){
        List<Map<String, Object>> meetList = dao.getMeetList();
        Assert.assertEquals(3,meetList.size());
    }
}
