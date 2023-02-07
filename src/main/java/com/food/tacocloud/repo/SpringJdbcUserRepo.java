package com.food.tacocloud.repo;

import com.food.tacocloud.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringJdbcUserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
