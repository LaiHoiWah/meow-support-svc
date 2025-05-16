package com.meowu.svc.support.core.sysmessage.manager;

import com.meowu.starter.commons.utils.AssertUtils;
import com.meowu.starter.web.security.stereotype.Manager;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.sysmessage.dao.SysMessageDao;
import com.meowu.svc.support.core.sysmessage.entity.SysMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Manager
public class SysMessageManager{

    @Autowired
    private SysMessageDao sysMessageDao;

    public SysMessage save(SysMessage message){
        AssertUtils.isNotNull(message, "System message must not be null");
        AssertUtils.isNotBlank(message.getCode(), "System message code must not be null");
        AssertUtils.isNotBlank(message.getLanguage(), "System message language must not be null");
        AssertUtils.isNotNull(message.getStatus(), "System message status must not be null");

        return sysMessageDao.save(message);
    }

    public SysMessage update(SysMessage message){
        AssertUtils.isNotNull(message, "System message must not be null");
        AssertUtils.isNotNull(message.getId(), "System message id must not be null");
        AssertUtils.isNotBlank(message.getCode(), "System message code must not be null");
        AssertUtils.isNotBlank(message.getLanguage(), "System message language must not be null");
        AssertUtils.isNotNull(message.getStatus(), "System message status must not be null");

        return sysMessageDao.update(message);
    }

    public void delete(Integer id){
        AssertUtils.isNotNull(id, "System message id must not be null");

        // search by id
        SysMessage message = sysMessageDao.getById(id);
        // validation
        AssertUtils.isNotNull(message, "System message cannot be found by Id [" + id + "]");
        // delete
        sysMessageDao.delete(message);
    }

    public List<SysMessage> find(String code, String content, RecordStatus status){
        return sysMessageDao.find(code, content, status);
    }
}
