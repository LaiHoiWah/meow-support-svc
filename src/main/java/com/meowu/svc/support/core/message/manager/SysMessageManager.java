package com.meowu.svc.support.core.message.manager;

import com.meowu.starter.commons.utils.AssertUtils;
import com.meowu.starter.web.security.stereotype.Manager;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.message.dao.SysMessageDao;
import com.meowu.svc.support.core.message.entity.SysMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Manager
public class SysMessageManager{

    @Autowired
    private SysMessageDao sysMessageDao;

    public SysMessage save(String code, String content, RecordStatus status){
        AssertUtils.isNotBlank(code, "System message code must not be null");

        SysMessage message = new SysMessage();
        message.setCode(code);
        message.setContent(content);
        message.setStatus(status);
        return sysMessageDao.save(message);
    }

    public List<SysMessage> find(String code, String content, RecordStatus status){
        return sysMessageDao.find(code, content, status);
    }
}
