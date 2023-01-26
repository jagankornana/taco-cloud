package com.food.tacocloud.service;

import com.food.tacocloud.model.jdbc.TacoOrder;
import com.food.tacocloud.repo.SpringJdbcTacoOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TacoOrderServiceImpl implements TacoOrderService {

    @Autowired
    private SpringJdbcTacoOrderRepo tacoOrderRepo;

    @Override
    public TacoOrder saveTacoOrder(TacoOrder tacoOrder) {
        return tacoOrderRepo.save(tacoOrder);
    }
}
