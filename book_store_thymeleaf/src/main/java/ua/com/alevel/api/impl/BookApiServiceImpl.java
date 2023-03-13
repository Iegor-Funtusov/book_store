package ua.com.alevel.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.com.alevel.api.BookApiService;
import ua.com.alevel.model.AuthorDetailsModel;
import ua.com.alevel.model.BookDetailsModel;
import ua.com.alevel.model.BookModel;

import java.util.Collection;
import java.util.Optional;

@Service
public class BookApiServiceImpl implements BookApiService {

    @Value("${bookstore.backend.api.url}")
    private String apiUrl;

    @Override
    public Collection<BookModel> findAll() {
        return null;
    }

    @Override
    public Optional<BookDetailsModel> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookDetailsModel> response = restTemplate.exchange(
                apiUrl + "/books/" + id,
                HttpMethod.GET,
                null,
                BookDetailsModel.class
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            BookDetailsModel bookDetailsModel = response.getBody();
            if (bookDetailsModel != null) {
                return Optional.of(bookDetailsModel);
            }
        }
        return Optional.empty();
    }
}
