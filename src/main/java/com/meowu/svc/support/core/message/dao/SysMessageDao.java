package com.meowu.svc.support.core.message.dao;

import com.meowu.starter.commons.utils.AssertUtils;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.message.dao.repository.SysMessageRepository;
import com.meowu.svc.support.core.message.dao.repository.specification.SysMessageSpecification;
import com.meowu.svc.support.core.message.entity.SysMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SysMessageDao{

    @Autowired
    private SysMessageRepository repository;

    public SysMessage save(SysMessage message){
        AssertUtils.isNotNull(message, "Save entity must not be null");
        AssertUtils.isNotBlank(message.getCode(), "Save code must not be null");
        AssertUtils.isNotNull(message.getStatus(), "Save status must not be null");

        // set create time
        message.setCreateTime(new Date());
        // save
        return repository.save(message);
    }

    public List<SysMessage> find(String code, String content, RecordStatus status){
        return repository.findAll(SysMessageSpecification.find(code, content, status));
    }

    public SysMessage getById(Integer id){
        AssertUtils.isNotNull(id, "Search id must not be null");
        return repository.findOneById(id);
    }

    public SysMessage getByCode(String code){
        AssertUtils.isNotBlank(code, "Search code must not be null");
        return repository.findOneByCode(code);
    }
}
