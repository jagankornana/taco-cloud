package com.food.tacocloud.service;

import com.food.tacocloud.domain.TacoOrder;

public interface TacoOrderService {
    TacoOrder saveTacoOrder(TacoOrder tacoOrder);

    TacoOrder findTacoOrderById(Long id);
}
