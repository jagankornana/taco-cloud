package com.food.tacocloud.controller;

import com.food.tacocloud.domain.Ingredient;
import com.food.tacocloud.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RequestMapping("/taco/ingredient")
@RestController
@Slf4j
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping("/all")
    public List<Ingredient> getAllIngredients() {
        log.info("getAllIngredients");
        return ingredientService.getAllIngredients();
    }

    @GetMapping()
    public Optional<Ingredient> getIngredientById(@RequestParam("id") String id) {
        log.info("getIngredientById: {}", id);
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/name")
    public Iterable<Ingredient> getIngredientsByName(@RequestParam("name") String name) {
        log.info("getIngredientsByName: {}", name);
        return ingredientService.getIngredientsByName(name);
    }

    @GetMapping("/nameContains")
    public Iterable<Ingredient> getIngredientsByNameContains(@RequestParam("name") String name) {
        log.info("getIngredientsByNameContains: {}", name);
        return ingredientService.getIngredientsByNameContains(name);
    }

    @GetMapping("/type")
    public Iterable<Ingredient> getIngredientsByType(@RequestParam("type") Ingredient.Type type) {
        log.info("getIngredientsByType: {}", type);
        return ingredientService.getIngredientsByType(type);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ingredient> saveIngredient(@Valid @RequestBody Ingredient ingredient) {
        log.info("saveIngredient: {}", ingredient);
        return new ResponseEntity<>(ingredientService.saveIngredient(ingredient), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public void deleteIngredientById(@RequestParam("id") String id) {
        log.info("deleteIngredientById: {}", id);
        ingredientService.deleteIngredientById(id);
    }
}
