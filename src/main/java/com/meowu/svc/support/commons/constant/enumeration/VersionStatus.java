package com.meowu.svc.support.commons.constant.enumeration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum VersionStatus{

    ACTIVE("Active", "A"),

    DEPRECATE("Deprecate", "DP"),

    DELETE("Delete", "D"),

    ;

    private final String name;
    private final String value;

    public static VersionStatus getByValue(String value){
        if(StringUtils.isBlank(value)){
            throw new IllegalArgumentException("Version status value must not be null");
        }

        for(VersionStatus status : VersionStatus.values()){
            if(status.getValue().equals(value)){
                return status;
            }
        }

        throw new IllegalArgumentException("No version status can be found by value[" + value + "]");
    }
}
