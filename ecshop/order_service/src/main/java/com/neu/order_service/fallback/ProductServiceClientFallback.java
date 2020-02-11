package com.neu.order_service.fallback;

import com.neu.order_service.client.ProductServiceClient;
import com.neu.product_service.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceClientFallback implements ProductServiceClient {


    @Override
    public Product findById(Integer productId) {

        Product product =new Product();
        product.setName("id为"+productId+"的商品库存不足");

        return product;
    }
}
