package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.api.BookApiService;
import ua.com.alevel.model.BookDetailsModel;

import java.util.Optional;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookApiService bookApiService;

    @GetMapping("/{id}")
    public String findAuthorById(@PathVariable Long id, Model model) {
        Optional<BookDetailsModel> bookDetailsModelOptional = bookApiService.findById(id);
        if (bookDetailsModelOptional.isPresent()) {
            model.addAttribute("book", bookDetailsModelOptional.get());
            return "pages/open/pdp/book_details";
        }
        return "pages/404";
    }
}
