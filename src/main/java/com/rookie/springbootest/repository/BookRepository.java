package com.rookie.springbootest.repository;

import com.rookie.springbootest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
