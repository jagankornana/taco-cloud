package com.food.tacocloud.service;

import com.food.tacocloud.model.jdbc.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> getAllIngredients();

    Optional<Ingredient> getIngredientById(String id);

    Ingredient saveIngredient(Ingredient ingredient);

    void deleteIngredientById(String id);
}
