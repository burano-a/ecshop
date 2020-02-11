package com.neu.order_service.dao;

import com.neu.order_service.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao {
    int add(Book book);
}
