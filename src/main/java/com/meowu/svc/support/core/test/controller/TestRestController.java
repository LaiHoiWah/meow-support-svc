package com.meowu.svc.support.core.test.controller;

import com.meowu.starter.web.security.response.Response;
import com.meowu.starter.web.security.response.ResponseCode;
import com.meowu.svc.support.core.test.entity.Test;
import com.meowu.svc.support.core.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/test")
public class TestRestController{

    @Autowired
    private TestService testService;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get(){
        return new Response(ResponseCode.SUCCESS, "Get API success");
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response post(){
        return new Response(ResponseCode.SUCCESS, "Post API success");
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody Test test){
        test = testService.save(test);

        Response response = new Response();
        response.setCode(ResponseCode.SUCCESS);
        response.setData(test);
        return response;
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody Test test){
        test = testService.update(test);

        Response response = new Response();
        response.setCode(ResponseCode.SUCCESS);
        response.setData(test);
        return response;
    }
}
