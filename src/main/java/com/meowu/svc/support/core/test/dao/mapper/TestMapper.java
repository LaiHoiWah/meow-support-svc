package com.meowu.svc.support.core.test.dao.mapper;

import com.meowu.svc.support.core.test.dao.provider.TestProvider;
import com.meowu.svc.support.core.test.entity.Test;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface TestMapper{

    @InsertProvider(type = TestProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Test test);

    @UpdateProvider(type = TestProvider.class, method = "update")
    void update(Test test);
}
