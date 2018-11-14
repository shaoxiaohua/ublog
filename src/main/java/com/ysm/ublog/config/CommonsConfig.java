package com.ysm.ublog.config;

import com.ysm.ublog.utils.FastDfsUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

@Configuration
public class CommonsConfig {
    //在yml文件中的配置在这里使用
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;

    //配置JedisPool
    @Bean
    public JedisPool jedispool(JedisPoolConfig jedisPoolConfig){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,50000,password);
        return jedisPool;
    }

    @Bean
    public JedisPoolConfig jdeisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMinIdle(10);
        return jedisPoolConfig;
    }
    @Bean
    public FastDfsUtils fastDfsUtils() throws IOException, MyException {
        FastDfsUtils fastDfsUtils = new FastDfsUtils("classpath:conf.properties");
        return  fastDfsUtils;
    }
}
