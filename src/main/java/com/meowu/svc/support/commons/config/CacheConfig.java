package com.meowu.svc.support.commons.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig{

    @Value("${cache.caffeine.maximum-size}")
    private Integer maximumSize;

    @Value("${cache.caffeine.expireAfterWrit}")
    private Integer expireAfterWrite;

    @Bean
    public CacheManager cacheManager(Caffeine<Object, Object> caffeine){
        CaffeineCacheManager manager = new CaffeineCacheManager();
        manager.setCaffeine(caffeine);
        return manager;
    }

    @Bean
    public Caffeine<Object, Object> caffeine(){
        return Caffeine.newBuilder()
                       .maximumSize(maximumSize)
                       .expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS);
    }
}
