package com.food.tacocloud.controller;

import com.food.tacocloud.model.jdbc.TacoOrder;
import com.food.tacocloud.service.TacoOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/taco/order")
public class TacoOrderController {

    @Autowired
    private TacoOrderService tacoOrderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TacoOrder saveTacoOrder(@Valid @RequestBody TacoOrder tacoOrder) {
        log.info("saveTacoOrder: {}", tacoOrder);
        return tacoOrderService.saveTacoOrder(tacoOrder);
    }

    @GetMapping
    public TacoOrder getTacoOrderById(@RequestParam("id") Long id) {
        log.info("getTacoOrderById: {}", id);
        return tacoOrderService.findTacoOrderById(id);
    }
}
