package com.meowu.svc.support.core.sysmessage.dao.repository.specification;

import com.meowu.svc.support.commons.constant.enumeration.RecordStatus;
import com.meowu.svc.support.core.sysmessage.entity.SysMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class SysMessageSpecification{

    public static Specification<SysMessage> find(String code, String content, RecordStatus status){
        return (root, query, cb) -> {
            // conditions
            if(StringUtils.isNotBlank(code)){
                query.where(cb.like(root.get(SysMessage.Fields.code), "%" + code + "%"));
            }
            if(StringUtils.isNotBlank(content)){
                query.where(cb.like(root.get(SysMessage.Fields.content), "%" + content + "%"));
            }
            if(Objects.nonNull(status)){
                query.where(cb.equal(root.get(SysMessage.Fields.status), status));
            }
            // default sorting
            query.orderBy(cb.asc(root.get(SysMessage.Fields.code)));

            return query.getRestriction();
        };
    }
}
