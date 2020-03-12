package com.rookie.springbootest.controller;

import com.rookie.springbootest.entity.Book;
import com.rookie.springbootest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return bookRepository.findAll(pageRequest);
    }
    @PostMapping("/save")
    public String save(@RequestBody Book book){
       Book result= bookRepository.save(book);
       if(result!=null){
           return "success";
       }
       else {
           return "flase";
       }

    }

}
