package com.food.tacocloud.config;

import static com.food.tacocloud.domain.Ingredient.Type;

import com.food.tacocloud.domain.Ingredient;
import com.food.tacocloud.repo.SpringJdbcIngredientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

    //    @Bean
    public CommandLineRunner dataLoader(SpringJdbcIngredientRepo ingredientRepo) {
        return args -> {
            ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
