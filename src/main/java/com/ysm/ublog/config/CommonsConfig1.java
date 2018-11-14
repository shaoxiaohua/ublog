package com.ysm.ublog.config;

import com.ysm.ublog.utils.FastDfsUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

/**
 * @author hua
 * @date 2018/11/7 15:23.
 */
@Configuration
public class CommonsConfig1 {
    @Value(("${spring.redis.host}"))
    private String host;
    @Value(("${spring.redis.port}"))
    private int port;
    @Value(("${spring.redis.password}"))
    private String password;
   @Bean
    public FastDfsUtils fastDfsUtils() throws IOException, MyException {
        FastDfsUtils fastDfsUtils = new FastDfsUtils("classpath:conf.properties");
        return  fastDfsUtils;
    }


   @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig){
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port,5000,password);
        return  jedisPool;
   }

   @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxTotal(1024);
        return jedisPoolConfig;
   }
}
