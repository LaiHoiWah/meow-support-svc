package com.meowu.svc.support.commons.config;

import com.meowu.svc.support.commons.constant.converter.mvc.RecordStatusConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new RecordStatusConverter());
    }
}
