package com.food.tacocloud.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    private Double amount;

    @NotEmpty
    private String address;

    private Date placedAt = new Date();

    @Valid
    @NotEmpty
    private List<Taco> tacos = new ArrayList<>();

    public boolean addTaco(Taco taco) {
        return tacos.add(taco);
    }

}
