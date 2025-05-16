package com.meowu.svc.support.core.message.service;

import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.message.dto.SysMessageDto;
import com.meowu.svc.support.core.message.dto.SysMessageReq;

import java.util.List;

public interface SysMessageService{

    SysMessageDto save(SysMessageDto request);

    List<SysMessageDto> find(String code, String content, RecordStatus status);
}
