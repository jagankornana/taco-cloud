package com.food.tacocloud.repo;

import com.food.tacocloud.model.jdbc.Ingredient;

import java.util.List;
import java.util.Optional;

public interface JdbcIngredientRepo {
    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

    void deleteById(String id);
}
