package com.vector.authorbook.controller;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.entity.Book;
import com.vector.authorbook.repository.AuthorRepository;
import com.vector.authorbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping()
    public String bookPage(ModelMap modelMap) {
        List<Book> books = bookRepository.findAll();
        modelMap.put("books", books);
        return "book/books";
    }

    @GetMapping("/add")
    public String addBookPage(ModelMap modelMap) {
        List<Author> authors = authorRepository.findAll();
        modelMap.put("authors", authors);
        return "book/addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute  Book book) {
        book.setCreatedAt(new Date());
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam ("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
