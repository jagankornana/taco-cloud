package com.food.tacocloud.service;

import com.food.tacocloud.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> getAllIngredients();

    Optional<Ingredient> getIngredientById(String id);

    Iterable<Ingredient> getIngredientsByName(String name);

    Iterable<Ingredient> getIngredientsByNameContains(String name);

    Iterable<Ingredient> getIngredientsByType(Ingredient.Type type);

    Ingredient saveIngredient(Ingredient ingredient);

    void deleteIngredientById(String id);

}
