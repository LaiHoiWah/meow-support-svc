package com.meowu.svc.support.core.audit.entity;

import com.meowu.starter.data.core.entity.Creatable;
import com.meowu.starter.data.core.entity.Identity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "audit_log")
public class AuditLog implements Identity<Integer>, Creatable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "search_key_1", nullable = false)
    private String searchKey1;

    @Column(name = "search_key_2", nullable = false)
    private String searchKey2;

    @Column(name = "search_key_3")
    private String searchKey3;

    @Column(name = "search_key_4")
    private String searchKey4;

    @Column(name = "module", nullable = false)
    private String module;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "operator", nullable = false)
    private String operator;

    @Column(name = "create_time", nullable = false)
    private Date createTime;
}
