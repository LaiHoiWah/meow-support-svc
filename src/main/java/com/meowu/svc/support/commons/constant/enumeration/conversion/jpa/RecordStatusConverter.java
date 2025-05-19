package com.meowu.svc.support.commons.constant.enumeration.conversion.jpa;

import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class RecordStatusConverter implements AttributeConverter<RecordStatus, String>{

    @Override
    public String convertToDatabaseColumn(RecordStatus status){
        return Objects.isNull(status) ? null : status.getValue();
    }

    @Override
    public RecordStatus convertToEntityAttribute(String value){
        return StringUtils.isBlank(value) ? null : RecordStatus.getByValue(value);
    }
}
