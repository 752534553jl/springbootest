package com.rookie.springbootest.repository;

import com.rookie.springbootest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());

    }

    /**
     * JPA分页功能测试
     * 先将数据库数据全部查出来，然后在分页显示
     */
    @Test
    void contextLoads(){
        PageRequest pageRequest=PageRequest.of(0,3);
        Page<Book> page=bookRepository.findAll(pageRequest);
    }

    /**
     * JPA插入功能测试
     */
    @Test
    void save(){
        Book book =new Book();
        book.setName("java");
        book.setAuthor("张三");
        Book book1 =bookRepository.save(book);
        System.out.println(book1);
    }

}