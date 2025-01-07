package com.vector.authorbook.service;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

public interface AuthorService {

    Page<Author> findAll(Pageable pageable);

    List<Author> findAll();

    Author save(Author author);

    void deleteById(int id);

    Author findById(int id);

    List<Author> search(String keyword);

    List<Author> filter(SearchCriteria searchCriteria);
}
