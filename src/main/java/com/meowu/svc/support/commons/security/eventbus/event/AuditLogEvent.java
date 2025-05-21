package com.meowu.svc.support.commons.security.eventbus.event;

import com.meowu.starter.data.core.entity.Creatable;
import com.meowu.starter.data.core.entity.Updatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogEvent implements Creatable, Updatable{

    private Date createTime;
    private Date updateTime;
}
