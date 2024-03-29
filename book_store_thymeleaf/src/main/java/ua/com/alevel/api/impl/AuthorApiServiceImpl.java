package ua.com.alevel.api.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ua.com.alevel.api.AuthorApiService;
import ua.com.alevel.model.AuthorDetailsModel;
import ua.com.alevel.model.AuthorModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorApiServiceImpl implements AuthorApiService {

    @Value("${bookstore.backend.api.url}")
    private String apiUrl;

    @Override
    public Collection<AuthorModel> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AuthorModel[]> response = restTemplate.exchange(
                apiUrl + "/authors",
                HttpMethod.GET,
                null,
                AuthorModel[].class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            AuthorModel[] authorModels = response.getBody();
            if (authorModels != null) {
                return List.of(authorModels);
            }
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<AuthorDetailsModel> findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Object> response = restTemplate.exchange(
                    apiUrl + "/authors/" + id,
                    HttpMethod.GET,
                    null,
                    Object.class
            );
            if (response.getStatusCode().is2xxSuccessful()) {
                AuthorDetailsModel authorDetailsModel = (AuthorDetailsModel) response.getBody();
                if (authorDetailsModel != null) {
                    return Optional.of(authorDetailsModel);
                }
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
