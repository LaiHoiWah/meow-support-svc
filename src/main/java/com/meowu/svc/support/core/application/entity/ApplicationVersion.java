package com.meowu.svc.support.core.application.entity;

import com.meowu.starter.data.core.entity.Creatable;
import com.meowu.starter.data.core.entity.Deletable;
import com.meowu.starter.data.core.entity.Identity;
import com.meowu.starter.data.core.entity.Updatable;
import com.meowu.svc.support.commons.constant.enumeration.VersionStatus;
import com.meowu.svc.support.commons.constant.enumeration.conversion.jpa.VersionStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@Getter
@Setter
@FieldNameConstants
@Entity
@Table(name = "application_version")
public class ApplicationVersion implements Identity<Integer>, Creatable, Updatable, Deletable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "application_id", nullable = false)
    private Integer applicationId;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "description")
    private String description;

    @Column(name = "status", nullable = false)
    @Convert(converter = VersionStatusConverter.class)
    private VersionStatus status;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "delete_time")
    private Date deleteTime;
}
