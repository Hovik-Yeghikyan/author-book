package com.vector.authorbook.service.impl;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceMapImpl implements AuthorService {

    @Override
    public List<Author> findAll() {
        return List.of();
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Author findById(int id) {
        return null;
    }
}
