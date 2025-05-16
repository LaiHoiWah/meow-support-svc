package com.meowu.svc.support.core.message.dto;

import com.meowu.svc.support.commons.constant.RecordStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysMessageReq{

    private Integer id;
    private String code;
    private String content;
    private RecordStatus status;
}
