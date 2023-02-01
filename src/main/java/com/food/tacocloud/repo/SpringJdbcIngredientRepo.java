package com.food.tacocloud.repo;

import com.food.tacocloud.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJdbcIngredientRepo extends CrudRepository<Ingredient, String> {
    Iterable<Ingredient> findByName(String name);

    Iterable<Ingredient> findByNameContains(String name);

    Iterable<Ingredient> findByType(Ingredient.Type type);


}
