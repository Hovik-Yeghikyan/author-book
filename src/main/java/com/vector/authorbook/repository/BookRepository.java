package com.vector.authorbook.repository;

import com.vector.authorbook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
