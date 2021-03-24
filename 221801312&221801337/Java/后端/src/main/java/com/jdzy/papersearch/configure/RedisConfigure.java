package com.jdzy.papersearch.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.stereotype.Component;

//@Configuration
//public class RedisConfigure  {
//    @Autowired
//    private RedisConnectionFactory connectionFactory;
//    @Bean(name="cacheManger")
//    public CacheManager initRedisCacheManager(){
//        RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
////        config=config.serializeValuesWith()
//    }
//}
