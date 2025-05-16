package com.meowu.svc.support.core.message.controller;

import com.meowu.starter.web.security.response.Response;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.message.dto.SysMessageDto;
import com.meowu.svc.support.core.message.dto.SysMessageReq;
import com.meowu.svc.support.core.message.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/system/message")
public class SysMessageController{

    @Autowired
    private SysMessageService sysMessageService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody SysMessageDto request){
        return new Response(sysMessageService.save(request));
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response find(@RequestParam(name = "code", required = false) String code,
                         @RequestParam(name = "content", required = false) String content,
                         @RequestParam(name = "status", required = false) RecordStatus status){
        return new Response(sysMessageService.find(code, content, status));
    }
}
