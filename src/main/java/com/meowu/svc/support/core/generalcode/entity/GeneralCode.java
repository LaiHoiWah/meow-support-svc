package com.meowu.svc.support.core.generalcode.entity;

import com.meowu.starter.data.core.entity.Creatable;
import com.meowu.starter.data.core.entity.Deletable;
import com.meowu.starter.data.core.entity.Identity;
import com.meowu.starter.data.core.entity.Updatable;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.commons.constant.converter.jpa.RecordStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "general_code")
public class GeneralCode implements Identity<Integer>, Creatable, Updatable, Deletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    @Convert(converter = RecordStatusConverter.class)
    private RecordStatus status;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "delete_time")
    private Date deleteTime;
}
