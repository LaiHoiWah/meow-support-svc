package com.meowu.svc.support.core.test.dao;

import com.meowu.svc.support.core.test.dao.mapper.TestMapper;
import com.meowu.svc.support.core.test.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class TestDao{

    @Autowired
    private TestMapper testMapper;

    public Test save(Test test){
        test.setCreateTime(new Date());
        testMapper.save(test);

        return test;
    }

    public Test update(Test test){
        test.setUpdateTime(new Date());
        testMapper.update(test);

        return test;
    }
}
