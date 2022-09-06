package com.elite.springboot.service;

import com.elite.springboot.entity.Product;

import java.util.List;

/**
 * 服务接口类
 */
public interface IProductService {
    //保存
    void saveProduct(Product product);

    //更新
    void updateProduct(Product product);

    //根据
     Product getProductById(Long id);

    //获取商品列表
     List<Product> getProductList();

    //删除商品
     void deleteProductById(Long id);
}
