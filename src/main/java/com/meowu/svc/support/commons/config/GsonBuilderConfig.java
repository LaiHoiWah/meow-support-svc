package com.meowu.svc.support.commons.config;

import com.google.common.collect.Lists;
import com.google.gson.GsonBuilder;
import com.meowu.starter.commons.utils.GsonUtils;
import com.meowu.starter.commons.utils.adapter.DateAdapter;
import com.meowu.starter.commons.utils.adapter.TypeAdapter;
import com.meowu.svc.support.commons.constant.enumeration.conversion.gson.RecordStatusAdapter;
import com.meowu.svc.support.commons.constant.enumeration.conversion.gson.VersionStatusAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConditionalOnProperty(value = "meowu.web.converter", havingValue = "gson")
public class GsonBuilderConfig{

    @Bean
    public GsonBuilder gsonBuilder(){
        List<TypeAdapter> adapters = Lists.newArrayList(
            new DateAdapter(),
            new RecordStatusAdapter(),
            new VersionStatusAdapter()
        );

        return GsonUtils.getBuilder(true, true, adapters.toArray(TypeAdapter[]::new));
    }
}
