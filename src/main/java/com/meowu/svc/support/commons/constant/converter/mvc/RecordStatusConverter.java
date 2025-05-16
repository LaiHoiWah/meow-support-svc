package com.meowu.svc.support.commons.constant.converter.mvc;

import com.meowu.svc.support.commons.constant.RecordStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class RecordStatusConverter implements Converter<String, RecordStatus>{

    @Override
    public RecordStatus convert(String value){
        return StringUtils.isBlank(value) ? null : RecordStatus.getByValue(value);
    }
}
