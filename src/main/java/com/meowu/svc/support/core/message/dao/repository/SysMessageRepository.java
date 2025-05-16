package com.meowu.svc.support.core.message.dao.repository;

import com.meowu.svc.support.core.message.entity.SysMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMessageRepository extends JpaRepository<SysMessage, Integer>, JpaSpecificationExecutor<SysMessage>{

    SysMessage findOneById(Integer id);

    SysMessage findOneByCode(String code);
}
