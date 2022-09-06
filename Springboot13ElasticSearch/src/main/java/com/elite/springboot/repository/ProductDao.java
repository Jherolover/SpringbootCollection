package com.elite.springboot.repository;

import com.elite.springboot.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 持久化类
 * 操作文档
 */
public interface ProductDao extends ElasticsearchRepository<Product,Long> {
}
