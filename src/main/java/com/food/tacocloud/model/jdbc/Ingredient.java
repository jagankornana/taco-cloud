package com.food.tacocloud.model.jdbc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"new"})
@Data
@Table
public class Ingredient implements Persistable<String> {
    @Id
    @NotBlank(message = "id should not be blank")
    private String id;

    @NotBlank(message = "name should not be blank")
    private String name;

    private Type type;

    @Override
    public boolean isNew() {
        return true;
    }

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}
