package com.example.recipeapp.demo.model;

import java.util.List;

public class RecipeApiResponse {

    private List<RecipeDetails> recipes;

    public List<RecipeDetails> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDetails> recipes) {
        this.recipes = recipes;
    }

    public static class RecipeDetails {
        private String title;
        private String href;
        private String ingredients;

        // Getters e setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getIngredients() {
            return ingredients;
        }

        public void setIngredients(String ingredients) {
            this.ingredients = ingredients;
        }
    }
}
