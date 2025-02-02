package com.meowu.svc.support.core.test.entity;

import com.meowu.starter.data.core.entity.Identity;
import com.meowu.starter.data.mybatis.plugins.security.stereotype.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(value = "test")
public class Test implements Identity<Integer>{

    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;
}
