package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConfigProperties redisConfigProperties;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return jedisPoolConfig;
    }

    @Bean(name = "jedisPool")
    public JedisPool getJedisPool(@Qualifier(value = "jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
        String host = redisConfigProperties.getHost();
        int port = redisConfigProperties.getPort();
        String password = redisConfigProperties.getPassword();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, 0, password);
        return jedisPool;
    }
}
