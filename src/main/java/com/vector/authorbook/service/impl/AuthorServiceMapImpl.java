package com.vector.authorbook.service.impl;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.service.AuthorService;
import com.vector.authorbook.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceMapImpl implements AuthorService {

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return new PageImpl<>(List.of()) {
        };
    }

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

    @Override
    public List<Author> search(String keyword) {
        return List.of();
    }

    @Override
    public List<Author> filter(SearchCriteria searchCriteria) {
        return List.of();
    }
}
