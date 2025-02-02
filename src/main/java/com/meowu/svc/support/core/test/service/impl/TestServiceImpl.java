package com.meowu.svc.support.core.test.service.impl;

import com.meowu.svc.support.core.test.dao.TestDao;
import com.meowu.svc.support.core.test.entity.Test;
import com.meowu.svc.support.core.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Transactional
    @Override
    public Test save(Test test){
        return testDao.save(test);
    }

    @Transactional
    @Override
    public Test update(Test test){
        return testDao.update(test);
    }
}
