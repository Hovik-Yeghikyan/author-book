package com.vector.authorbook.controller;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.entity.Book;
import com.vector.authorbook.repository.AuthorRepository;
import com.vector.authorbook.repository.BookRepository;
import com.vector.authorbook.service.AuthorService;
import com.vector.authorbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final AuthorService authorService;

    @GetMapping()
    public String bookPage(ModelMap modelMap) {
        List<Book> books = bookService.findAll();
        modelMap.put("books", books);
        return "book/books";
    }

    @GetMapping("/add")
    public String addBookPage(ModelMap modelMap) {
        List<Author> authors = authorService.findAll();
        modelMap.put("authors", authors);
        return "book/addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book,
                          @RequestParam("image") MultipartFile multipartFile) throws IOException {
        bookService.save(book,multipartFile);
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
