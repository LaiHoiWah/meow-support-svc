package com.meowu.svc.support.core.generalcode.dao;

import com.meowu.starter.commons.utils.AssertUtils;
import com.meowu.svc.support.commons.constant.RecordStatus;
import com.meowu.svc.support.core.generalcode.dao.repository.GeneralCodeRepository;
import com.meowu.svc.support.core.generalcode.dao.repository.specification.GeneralCodeSpecification;
import com.meowu.svc.support.core.generalcode.entity.GeneralCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class GeneralCodeDao{

    @Autowired
    private GeneralCodeRepository repository;

    public GeneralCode save(GeneralCode code){
        AssertUtils.isNotNull(code, "Save entity must not be null");
        AssertUtils.isNotBlank(code.getType(), "Save type must not be null");
        AssertUtils.isNotBlank(code.getCode(), "Save code must not be null");
        AssertUtils.isNotBlank(code.getDescription(), "Save description must not be null");
        AssertUtils.isNotNull(code.getStatus(), "Save status must not be null");

        // set create time
        code.setCreateTime(new Date());
        // save
        return repository.save(code);
    }

    public List<GeneralCode> find(String type, String code, RecordStatus status){
        return repository.findAll(GeneralCodeSpecification.find(type, code, status));
    }

    public List<GeneralCode> findByType(String type){
        AssertUtils.isNotBlank(type, "Search type must not be null");
        return repository.findAllByType(type);
    }

    public GeneralCode getById(Integer id){
        AssertUtils.isNotNull(id, "Search id must not be null");
        return repository.findOneById(id);
    }
}
