package com.meowu.svc.support.core.sysmessage.service;

import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.sysmessage.dto.SysMessageDto;

import java.util.List;

public interface SysMessageService{

    SysMessageDto save(SysMessageDto request);

    SysMessageDto update(SysMessageDto request);

    void delete(Integer id);

    List<SysMessageDto> find(String code, String content, RecordStatus status);
}
