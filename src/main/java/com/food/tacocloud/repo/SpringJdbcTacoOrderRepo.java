package com.food.tacocloud.repo;

import com.food.tacocloud.model.jdbc.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJdbcTacoOrderRepo extends CrudRepository<TacoOrder, Long> {
}
