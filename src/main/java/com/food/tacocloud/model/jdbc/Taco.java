package com.food.tacocloud.model.jdbc;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Taco {
    @Id
    private Long id;

    @NotEmpty
    private String name;

    private Long tacoOrder;

    private Date createdAt = new Date();

    @Valid
    @NotEmpty
    private List<IngredientRef> ingredients = new ArrayList<>();
}
