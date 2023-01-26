package com.food.tacocloud.repo;

import com.food.tacocloud.model.jdbc.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcIngredientRepoImpl implements JdbcIngredientRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> findAll() {
        String query = "select id, name, type from ingredient";
        return jdbcTemplate.query(query, this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        String query = "select id, name, type from ingredient where id = ?";
        List<Ingredient> ingredients = jdbcTemplate.query(query, this::mapRowToIngredient, id);
        return ingredients.isEmpty() ? Optional.of(new Ingredient()) : Optional.of(ingredients.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        String query = "insert into ingredient values(?, ?, ?)";
        jdbcTemplate.update(query, ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    @Override
    public void deleteById(String id) {
        String query = "delete from ingredient where id = ?";
        jdbcTemplate.update(query, id);
    }

    public Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(rs.getString("id"));
        ingredient.setName(rs.getString("name"));
        ingredient.setType(Ingredient.Type.valueOf(rs.getString("type")));
        return ingredient;
    }
}
