package com.food.tacocloud.repo;

import com.food.tacocloud.domain.TacoOrder;

public interface JdbcTacoOrderRepo {
    TacoOrder save(TacoOrder tacoOrder);
}
