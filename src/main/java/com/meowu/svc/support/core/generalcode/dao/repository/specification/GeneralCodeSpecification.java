package com.meowu.svc.support.core.generalcode.dao.repository.specification;

import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.core.generalcode.entity.GeneralCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class GeneralCodeSpecification{

    public static Specification<GeneralCode> find(String type, String code, RecordStatus status){
        return (root, query, cb) -> {
            // conditions
            if(StringUtils.isNotBlank(type)){
                query.where(cb.like(root.get(GeneralCode.Fields.type), "%" + type + "%"));
            }
            if(StringUtils.isNotBlank(code)){
                query.where(cb.like(root.get(GeneralCode.Fields.code), "%" + code + "%"));
            }
            if(Objects.nonNull(status)){
                query.where(cb.equal(root.get(GeneralCode.Fields.status), status));
            }

            // default sorting
            query.orderBy(
                cb.asc(root.get(GeneralCode.Fields.type)),
                cb.asc(root.get(GeneralCode.Fields.code))
            );

            return query.getRestriction();
        };
    }
}
