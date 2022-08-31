package com.elite.springboot.service.impl;

import com.elite.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis 实现类
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 保存key value
     * @param key
     * @param value
     */
    @Override
    public void saveKeyValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    /**
     * 设置过期时间
     * @param key
     * @param value
     * @param expiration 过期时间
     */
    @Override
    public void saveKeyValue(String key, Object value, int expiration) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, expiration, TimeUnit.MINUTES);
    }
    /**
     * 根据key获取value
     * @param key
     * @return
     */
    @Override
    public String getValueByKey(String key) {
        try {
            String value = redisTemplate.opsForValue().get(key).toString();
            return value;
        } catch (Exception e) {
            return "";
        }
    }
    /**
     * 删除缓存
     * @param key
     */
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 清空所有的缓存
     */
    @Override
    public void flushdb() {
        redisTemplate.getConnectionFactory().getConnection().flushDb();
    }
}
