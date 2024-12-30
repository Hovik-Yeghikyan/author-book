package com.vector.authorbook.controller;

import com.vector.authorbook.entity.UserType;
import com.vector.authorbook.service.security.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

@Controller
@Slf4j
public class MainController {

    @Value("${author.book.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String mainPage(Locale locale) {
        log.info("Main Page was opened, locale {}", locale.getLanguage());
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            return "redirect:/";
        }
        return "loginPage";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null && currentUser.getUser() != null) {
            log.info("user with {} email logged in", currentUser.getUser().getEmail());
            if (currentUser.getUser().getUserType() == UserType.ADMIN) {
                return "redirect:/admin";
            }
        }
        return "redirect:/";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("imageName") String imageName) throws IOException {
        File file = new File(uploadPath + imageName);
        if (file.exists()) {
            try (InputStream in = new FileInputStream(file)) {
                return IOUtils.toByteArray(in);
            }
        }
        return null;
    }
}
