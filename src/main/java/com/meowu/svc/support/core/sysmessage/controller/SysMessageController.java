package com.meowu.svc.support.core.sysmessage.controller;

import com.meowu.starter.web.security.response.Response;
import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.core.sysmessage.dto.SysMessageDto;
import com.meowu.svc.support.core.sysmessage.service.SysMessageService;
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

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody SysMessageDto request){
        return new Response(sysMessageService.update(request));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@PathVariable(name = "id") Integer id){
        sysMessageService.delete(id);
        return new Response();
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response find(@RequestParam(name = "code", required = false) String code,
                         @RequestParam(name = "content", required = false) String content,
                         @RequestParam(name = "status", required = false) RecordStatus status){
        return new Response(sysMessageService.find(code, content, status));
    }
}
