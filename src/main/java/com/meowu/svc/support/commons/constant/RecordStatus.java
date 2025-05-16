package com.meowu.svc.support.commons.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum RecordStatus{

    ACTIVE("Active", "A"),

    INACTIVE("Inactive", "I"),

    DELETE("Delete", "D"),

    ;

    private final String name;
    private final String value;

    public static RecordStatus getByValue(String value){
        if(StringUtils.isBlank(value)){
            throw new IllegalArgumentException("Record status value must not be null");
        }

        for(RecordStatus status : RecordStatus.values()){
            if(status.getValue().equals(value)){
                return status;
            }
        }

        throw new IllegalArgumentException("No record status can be found by value[" + value + "]");
    }
}
