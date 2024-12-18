package com.vector.authorbook.service;

import com.vector.authorbook.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int id);

    Book save(Book book, MultipartFile multipartFile) throws IOException;

    void deleteById(int id);
}
