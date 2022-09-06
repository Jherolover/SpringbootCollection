package com.elite.springboot.controller;

import com.elite.springboot.entity.Product;
import com.elite.springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * es 控制类
 */
@RestController
public class ESController {

    @Autowired
    IProductService productService;

    @GetMapping("/welcome")
    public String test(){
        return "hello,welcome to es world!";
    }

    /**
     * 保存
     * @param product
     * @return
     */
    @PostMapping("/saveProduct")
    public String saveProduct(@RequestBody  Product product){
        productService.saveProduct(product);
        return "save success";
    }
    /**
     * 更新商品
     * @param product
     * @return
     */
    @PutMapping("/updateProduct")
    public String updateProduct(@RequestBody  Product product){
        productService.saveProduct(product);
        return "update success";
    }
    /**
     * 获取单个商品
     * @param id
     * @return
     */
    @GetMapping("/getProductById/{ProductId}")
    public Product getProductById(@PathVariable("ProductId")  Long id){
        Product product = productService.getProductById(id);
        return product;
    }

    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("/getProductList")
    public List<Product> getProductList(){
        return productService.getProductList();
    }
    /**
     * 删除商品
     */
    @DeleteMapping("/deleteProductById/{productId}")
    public String  deleteProductById(@PathVariable("productId")  Long id){
        productService.deleteProductById(id);
        return "delete success";
    }

}
