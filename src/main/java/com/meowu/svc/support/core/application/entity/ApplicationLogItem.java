package com.meowu.svc.support.core.application.entity;

import com.meowu.starter.data.core.entity.*;
import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.commons.constant.enumeration.conversion.jpa.RecordStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "application_log_item")
public class ApplicationLogItem implements Identity<Integer>, Sortable, Creatable, Updatable, Deletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "log_id", nullable = false)
    private Integer logId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "sequence", nullable = false)
    private Integer sequence;

    @Column(name = "content")
    private String content;

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
