package com.meowu.svc.support.core.sysmessage.dto.mapper;

import com.meowu.svc.support.core.sysmessage.entity.SysMessage;
import com.meowu.svc.support.core.sysmessage.dto.SysMessageDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper
public interface SysMessageMapper{

    SysMessageDto toDto(SysMessage message);

    List<SysMessageDto> toDtos(List<SysMessage> messages);

    SysMessage toEntity(SysMessageDto message);
}
