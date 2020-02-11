package com.neu.product_service.service.impl;

import com.neu.product_service.dao.ProductDao;
import com.neu.product_service.domain.Product;
import com.neu.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product findById(Integer productId) {
        return productDao.findById(productId);
    }
}
