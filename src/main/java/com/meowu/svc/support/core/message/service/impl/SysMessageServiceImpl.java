package com.meowu.svc.support.core.message.service.impl;

import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.message.dto.SysMessageReq;
import com.meowu.svc.support.core.message.entity.SysMessage;
import com.meowu.svc.support.core.message.dto.SysMessageDto;
import com.meowu.svc.support.core.message.dto.mapper.SysMessageMapper;
import com.meowu.svc.support.core.message.manager.SysMessageManager;
import com.meowu.svc.support.core.message.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class SysMessageServiceImpl implements SysMessageService{

    @Autowired
    private SysMessageMapper sysMessageMapper;

    @Autowired
    private SysMessageManager sysMessageManager;

    @Transactional
    @Override
    public SysMessageDto save(SysMessageDto request){
        String       code    = request.getCode();
        String       content = request.getContent();
        RecordStatus status  = request.getStatus();

        // save
        SysMessage message = sysMessageManager.save(code, content, status);
        // convert
        return sysMessageMapper.toDto(message);
    }

    @Override
    public List<SysMessageDto> find(String code, String content, RecordStatus status){
        // result
        List<SysMessage> messages = sysMessageManager.find(code, content, status);
        // convert
        return sysMessageMapper.toDtos(messages);
    }
}
