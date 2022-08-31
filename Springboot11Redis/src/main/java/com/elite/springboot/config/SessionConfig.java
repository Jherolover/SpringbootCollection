package com.elite.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
//@EnableRedisHttpSession
//配置失效时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60) //1分钟失效
public class SessionConfig {
}
