package com.neu.product_service.service;

import com.neu.product_service.domain.Product;

public interface ProductService {
    Product findById(Integer productId);

}
