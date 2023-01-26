package com.food.tacocloud.service;

import com.food.tacocloud.model.jdbc.TacoOrder;
import com.food.tacocloud.repo.SpringJdbcTacoOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TacoOrderServiceImpl implements TacoOrderService {

    @Autowired
    private SpringJdbcTacoOrderRepo tacoOrderRepo;

    @Override
    public TacoOrder saveTacoOrder(TacoOrder tacoOrder) {
        return tacoOrderRepo.save(tacoOrder);
    }

    @Override
    public TacoOrder findTacoOrderById(Long id) {
        Optional<TacoOrder> tacoOrder = tacoOrderRepo.findById(id);
        return tacoOrder.orElseGet(TacoOrder::new);
    }
}
