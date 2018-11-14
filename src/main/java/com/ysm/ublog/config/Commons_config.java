package com.ysm.ublog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class Commons_config {
    @Value(("${spring.redis.host}"))
    private String host;
    @Value(("${spring.redis.port}"))
    private int port;
    @Value(("${spring.redis.password}"))
    private String password;

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {

        JedisPool jedisPool=new JedisPool(jedisPoolConfig,host,port,5000,password);
        return jedisPool;
    }
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxTotal(1024);
        return jedisPoolConfig;
    }
}
