package com.neu.product_service.controller;

import com.neu.product_service.domain.Product;
import com.neu.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Thread.sleep;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${server.port}")
    private String port;

    @GetMapping("{id}")
    @ResponseBody
    public Product findById(@PathVariable("id") Integer productId){

       try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Product product=productService.findById(productId);

        product.setName(product.getName()+"======"+port);
        return productService.findById(productId);
    }
}
