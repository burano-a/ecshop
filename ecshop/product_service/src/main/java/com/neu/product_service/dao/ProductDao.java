package com.neu.product_service.dao;

import com.neu.product_service.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    Product findById(Integer productId);
}
