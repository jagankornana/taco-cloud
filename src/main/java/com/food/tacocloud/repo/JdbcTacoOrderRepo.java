package com.food.tacocloud.repo;

import com.food.tacocloud.model.jdbc.TacoOrder;

public interface JdbcTacoOrderRepo {
    TacoOrder save(TacoOrder tacoOrder);
}
