package com.elite.springboot.service;

import org.springframework.stereotype.Service;

/**
 * 定义访问redis的接口类
 *
 */
public interface RedisService {

    /**
     * 保存key value
     * @param key
     * @param value
     */
     void saveKeyValue(String key,Object value);

    /**
     * 保存key value
     * @param key
     * @param value
     */
    void saveKeyValue(String key,Object value,int expiration);

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    String getValueByKey(String key);


    /**
     * 根据key删除缓存
     * @param key
     */
    void delete(String key);

    /**
     * 清空所有缓存
     */
    void flushdb();

}
