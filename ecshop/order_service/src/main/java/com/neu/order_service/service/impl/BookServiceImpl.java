package com.neu.order_service.service.impl;

import com.neu.order_service.client.ProductServiceClient;
import com.neu.order_service.dao.BookDao;
import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookService;
import com.neu.product_service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    //RestTemplate restTemplate;
            ProductServiceClient productServiceClient;

    @Override
    public int add(Book book) {
        // save book&bookDetail

        List<BookDetail> bookDetails=book.getBookDetails();
        for(BookDetail bookDetail:bookDetails){

            int productId = bookDetail.getProductId();

            String URL="http://product-service/products/"+productId;
            //Product product = restTemplate.getForObject(URL, Product.class);
            Product product =productServiceClient.findById(productId);
            System.out.println(product.getName()+"-----");

            if(true){
                return 1;
            }
        }


        return bookDao.add(book);
    }
}
