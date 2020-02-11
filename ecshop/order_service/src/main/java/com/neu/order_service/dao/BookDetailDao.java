package com.neu.order_service.dao;

import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDetailDao {
    int add(BookDetail bookDetail);
}
