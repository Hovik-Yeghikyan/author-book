package com.vector.authorbook.controller;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public String authorPage(ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.put("authors", all);
        return "author/authors";
    }

    @GetMapping("/add")
    public String addAuthorPage() {
        return "author/addAuthor";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/edit")
    public String editAuthorPage(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            modelMap.put("author", author);
            return "author/editAuthor";
        }
        return "redirect:/authors";
    }

    @PostMapping("/edit")
    public String editAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }
}