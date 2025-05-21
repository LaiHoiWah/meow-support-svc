package com.meowu.svc.support.commons.security.eventbus.listener;

import com.meowu.starter.web.security.stereotype.Listener;
import com.meowu.svc.support.commons.security.eventbus.event.AuditLogEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

@Slf4j
@Listener
public class AuditLogListener{

    @EventListener
    public void onApplicationEvent(AuditLogEvent event){
        log.info("Test logger");
    }
}
