package com.meowu.svc.support.core.sysmessage.dao;

import com.meowu.starter.commons.utils.AssertUtils;
import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.core.sysmessage.dao.repository.SysMessageRepository;
import com.meowu.svc.support.core.sysmessage.dao.repository.specification.SysMessageSpecification;
import com.meowu.svc.support.core.sysmessage.entity.SysMessage;
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
        AssertUtils.isNotBlank(message.getLanguage(), "Save language must not be null");
        AssertUtils.isNotNull(message.getStatus(), "Save status must not be null");

        // set create time
        message.setCreateTime(new Date());
        // save
        return repository.save(message);
    }

    public SysMessage update(SysMessage message){
        AssertUtils.isNotNull(message, "Update entity must not be null");
        AssertUtils.isNotNull(message.getId(), "Update id must not be null");
        AssertUtils.isNotBlank(message.getCode(), "Update code must not be null");
        AssertUtils.isNotBlank(message.getLanguage(), "Update language must not be null");
        AssertUtils.isNotNull(message.getStatus(), "Update status must not be null");

        // set update time
        message.setUpdateTime(new Date());
        // update
        return repository.save(message);
    }

    public void delete(SysMessage message){
        AssertUtils.isNotNull(message, "Delete entity must not be null");
        AssertUtils.isNotNull(message.getId(), "Delete id must not be null");
        AssertUtils.isNotBlank(message.getCode(), "Delete code must not be null");
        AssertUtils.isNotBlank(message.getLanguage(), "Delete language must not be null");
        AssertUtils.isNotNull(message.getStatus(), "Delete status must not be null");

        // set delete time
        message.setStatus(RecordStatus.DELETE);
        message.setDeleteTime(new Date());
        // update
        repository.save(message);
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
