package com.meowu.svc.support.commons.constant.enumeration.conversion.jpa;

import com.meowu.svc.support.commons.constant.enumeration.VersionStatus;
import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class VersionStatusConverter implements AttributeConverter<VersionStatus, String>{

    @Override
    public String convertToDatabaseColumn(VersionStatus status){
        return Objects.isNull(status) ? null : status.getValue();
    }

    @Override
    public VersionStatus convertToEntityAttribute(String value){
        return StringUtils.isBlank(value) ? null : VersionStatus.getByValue(value);
    }
}
