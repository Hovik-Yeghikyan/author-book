package com.vector.authorbook.controller;

import com.vector.authorbook.entity.Author;
import com.vector.authorbook.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AuthorController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/authors")
    public String authorPage(ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.put("authors", all);
        return "authors";

    }

    @GetMapping("/authors/add")
    public String addAuthorPage() {
        return "addAuthor";
    }


    //    @PostMapping("/authors/add")
//    public String addAuthor(@RequestParam("name") String name,
//                            @RequestParam("surname") String surname,
//                            @RequestParam("phone") String phone,
//                            @RequestParam("dateOfBirthday") String date,
//                            @RequestParam("gender") Gender gender) throws ParseException {
//
//        Author author = Author.builder()
//                .name(name)
//                .surname(surname)
//                .phone(phone)
//                .gender(gender)
//                .dateOfBirthday(sdf.parse(date))
//                .build();
//        authorRepository.save(author);
//        return "redirect:/authors";
//    }
    @PostMapping("/authors/add")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/delete")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}