package com.meowu.svc.support.core.message.dto;

import com.meowu.svc.support.commons.constant.RecordStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SysMessageDto{

    private Integer id;

    private String code;

    private String content;

    private RecordStatus status;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
