package com.meowu.svc.support.commons.constant.enumeration.conversion.mvc;

import com.meowu.svc.support.commons.constant.enumeration.VersionStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class VersionStatusConverter implements Converter<String, VersionStatus>{

    @Override
    public VersionStatus convert(String value){
        return StringUtils.isBlank(value) ? null : VersionStatus.getByValue(value);
    }
}
