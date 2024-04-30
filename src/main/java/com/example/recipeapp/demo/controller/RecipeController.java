package com.example.recipeapp.demo.controller;
import com.example.recipeapp.demo.model.RecipeApiResponse;
import com.example.recipeapp.demo.service.RecipeApiNinjasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class RecipeController {

    private final RecipeApiNinjasService recipeService;

    public RecipeController(RecipeApiNinjasService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index"); // Define o nome do template HTML
        return modelAndView;
    }
    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeApiResponse.RecipeDetails>> searchRecipes(@RequestParam(required = false) String query) {
        if (query == null || query.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            List<RecipeApiResponse.RecipeDetails> recipes = recipeService.searchRecipes(query);
            return ResponseEntity.ok(recipes);
        }
    }
}
