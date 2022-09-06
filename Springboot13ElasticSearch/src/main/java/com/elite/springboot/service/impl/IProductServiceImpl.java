package com.elite.springboot.service.impl;

import com.elite.springboot.entity.Product;
import com.elite.springboot.repository.ProductDao;
import com.elite.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口服务实现类
 */
@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    ProductDao productDao;

    /**
     * 保存商品
     * @param product
     */
    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    /**
     * 更新商品
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
       productDao.save(product);
    }

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id).get();
    }

    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<Product> getProductList() {
        Iterable<Product> products = productDao.findAll();
        List<Product> productList = new ArrayList<>();
        for(Product product:products){
            productList.add(product);
        }
        return productList;
    }

    /**
     * 删除商品
     * @param id
     */
    @Override
    public void deleteProductById(Long id) {
         productDao.deleteById(id);
    }
}
