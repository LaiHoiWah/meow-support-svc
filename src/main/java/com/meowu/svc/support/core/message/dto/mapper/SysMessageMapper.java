package com.meowu.svc.support.core.message.dto.mapper;

import com.meowu.svc.support.core.message.entity.SysMessage;
import com.meowu.svc.support.core.message.dto.SysMessageDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SysMessageMapper{

    SysMessageDto toDto(SysMessage message);

    List<SysMessageDto> toDtos(List<SysMessage> messages);
}
