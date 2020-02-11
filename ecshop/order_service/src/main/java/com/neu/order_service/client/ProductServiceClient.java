package com.neu.order_service.client;

import com.neu.order_service.fallback.ProductServiceClientFallback;
import com.neu.product_service.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service",fallback = ProductServiceClientFallback.class)
public interface ProductServiceClient {

    //方法声明要

    @RequestMapping(value = "products/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product findById(@PathVariable("id") Integer productId);
}
