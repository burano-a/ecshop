package com.neu.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.neu.order_service.domain.Book;
import com.neu.order_service.domain.BookDetail;
import com.neu.order_service.service.BookService;
import com.neu.order_service.utils.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    //@PostMapping
    @PostMapping("{id}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "addFallback")
    public JsonModel add(@PathVariable("id") int id){

        //System.out.println(0 / id);
        JsonModel jsonModel=new JsonModel();
        //模拟下单（下单参数
        //下单的时候 ，页面传递的参数--
        //商品的id 和数量
        //
        Book book =new Book();
        BookDetail bookDetail =new BookDetail();
        bookDetail.setProductId(1);
        bookDetail.setProductCount(10);

        book.getBookDetails().add(bookDetail);

        jsonModel.setSuccess(bookService.add(book)==1);
        jsonModel.setMsg(jsonModel.isSuccess()?"下单成功":"下单失败");
        //页面
        return jsonModel;

    }


    public JsonModel addFallback(@PathVariable("id") int id){
        JsonModel jsonModel=new JsonModel();

        jsonModel.setSuccess(false);
        jsonModel.setMsg("熔断开启，因为被除数为"+id);
        return jsonModel;
    }
}
