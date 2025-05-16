package com.meowu.svc.support.core.generalcode.dao.repository;

import com.meowu.svc.support.core.generalcode.entity.GeneralCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GeneralCodeRepository extends JpaRepository<GeneralCode, Integer>, JpaSpecificationExecutor<GeneralCode>{

    GeneralCode findOneById(Integer id);

    List<GeneralCode> findAllByType(String type);
}
