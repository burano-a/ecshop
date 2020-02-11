package com.neu.order_service.service.impl;

import com.neu.order_service.dao.BookDetailDao;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookDetailService;
import org.springframework.beans.factory.annotation.Autowired;


public class BookDetailServiceImpl implements BookDetailService {

    @Autowired
    BookDetailDao bookDetailDao;

    @Override
    public int add(BookDetail bookDetail) {
        return bookDetailDao.add(bookDetail);
    }
}
