package ua.com.alevel.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.alevel.api.AuthorApiService;
import ua.com.alevel.model.AuthorDetailsModel;

import java.util.Optional;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {

    private final AuthorApiService authorApiService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("authors", authorApiService.findAll());
        return "pages/open/plp/authors";
    }

    @GetMapping("/{id}")
    public String findAuthorById(@PathVariable Long id, Model model) {
        Optional<AuthorDetailsModel> authorDetailsModelOptional = authorApiService.findById(id);
        if (authorDetailsModelOptional.isPresent()) {
            model.addAttribute("author", authorDetailsModelOptional.get());
            return "pages/open/pdp/author_details";
        }
        return "pages/404";
    }
}
