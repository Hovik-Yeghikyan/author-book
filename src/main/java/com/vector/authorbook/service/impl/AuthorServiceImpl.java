package com.vector.authorbook.service.impl;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.repository.AuthorRepository;
import com.vector.authorbook.service.AuthorService;
import com.vector.authorbook.specification.AuthorSpecification;
import com.vector.authorbook.specification.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public Page<Author> findAll(Pageable pageable) {
        Page<Author> authors = authorRepository.findAll(pageable);
        return authors;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> search(String keyword) {
        return authorRepository.findByNameContainingOrSurnameContaining(keyword,keyword);
    }

    @Override
    public List<Author> filter(SearchCriteria searchCriteria) {
        AuthorSpecification authorSpecification = new AuthorSpecification(searchCriteria);
        return authorRepository.findAll(authorSpecification);
    }
}
