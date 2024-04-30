package com.example.recipeapp.demo.service;

import com.example.recipeapp.demo.model.RecipeApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class RecipeApiNinjasService {

    private static final String API_URL = "https://api-ninjas.com/api/recipe";

    private final RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    public RecipeApiNinjasService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<RecipeApiResponse.RecipeDetails> searchRecipes(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("x-rapidapi-host", "api-ninjas.com");
        headers.set("x-rapidapi-key", apiKey);

        String endpoint = API_URL + "?q=" + query;

        ResponseEntity<RecipeApiResponse> responseEntity = restTemplate.exchange(
                endpoint,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                RecipeApiResponse.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            RecipeApiResponse responseBody = responseEntity.getBody();
            if (responseBody != null) {
                return responseBody.getRecipes();
            }
        }

        return Collections.emptyList();
    }
}
