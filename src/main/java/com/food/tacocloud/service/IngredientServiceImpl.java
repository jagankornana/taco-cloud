package com.food.tacocloud.service;

import com.food.tacocloud.model.jdbc.Ingredient;
import com.food.tacocloud.repo.SpringJdbcIngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private SpringJdbcIngredientRepo ingredientRepo;

    @Override
    public List<Ingredient> getAllIngredients() {
        Iterable<Ingredient> ingredientIterable = ingredientRepo.findAll();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientIterable.forEach(ingredients::add);
        return ingredients;
    }

    @Override
    public Optional<Ingredient> getIngredientById(String id) {
        return ingredientRepo.findById(id);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepo.save(ingredient);
    }

    @Override
    public void deleteIngredientById(String id) {
        ingredientRepo.deleteById(id);
    }
}
