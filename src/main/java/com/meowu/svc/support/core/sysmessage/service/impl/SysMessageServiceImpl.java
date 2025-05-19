package com.meowu.svc.support.core.sysmessage.service.impl;

import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.core.sysmessage.entity.SysMessage;
import com.meowu.svc.support.core.sysmessage.dto.SysMessageDto;
import com.meowu.svc.support.core.sysmessage.dto.mapper.SysMessageMapper;
import com.meowu.svc.support.core.sysmessage.manager.SysMessageManager;
import com.meowu.svc.support.core.sysmessage.service.SysMessageService;
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
        SysMessage convert = sysMessageMapper.toEntity(request);
        // save
        convert = sysMessageManager.save(convert);
        // convert
        return sysMessageMapper.toDto(convert);
    }

    @Transactional
    @Override
    public SysMessageDto update(SysMessageDto request){
        SysMessage convert = sysMessageMapper.toEntity(request);
        // update
        convert = sysMessageManager.update(convert);
        // convert
        return sysMessageMapper.toDto(convert);
    }

    @Transactional
    @Override
    public void delete(Integer id){
        sysMessageManager.delete(id);
    }

    @Override
    public List<SysMessageDto> find(String code, String content, RecordStatus status){
        // result
        List<SysMessage> messages = sysMessageManager.find(code, content, status);
        // convert
        return sysMessageMapper.toDtos(messages);
    }
}
