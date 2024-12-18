package com.vector.authorbook.service.impl;

import com.vector.authorbook.entity.Book;
import com.vector.authorbook.repository.BookRepository;
import com.vector.authorbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    @Value("${author.book.upload.path}")
    private String uploadPath;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public Book save(Book book, MultipartFile multipartFile) throws IOException {
        String fileName;
        if (!multipartFile.isEmpty()) {
            fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            File file = new File(uploadPath, fileName);
            multipartFile.transferTo(file);
            book.setImageName(fileName);
        }
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }


    @Override
    public void deleteById(int id) {
       bookRepository.deleteById(id);
    }
}
