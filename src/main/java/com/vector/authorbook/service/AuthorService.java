package com.vector.authorbook.service;

import com.vector.authorbook.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    Author save(Author author);

    void deleteById(int id);

    Author findById(int id);
}
