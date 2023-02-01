package com.food.tacocloud.repo;

import com.food.tacocloud.domain.IngredientRef;
import com.food.tacocloud.domain.Taco;
import com.food.tacocloud.domain.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
public class JdbcTacoOrderRepoImpl implements JdbcTacoOrderRepo {

    private JdbcOperations jdbcOperations;

    public JdbcTacoOrderRepoImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder tacoOrder) {
        String query = "insert into taco_order(amount, address, placed_at) values(?, ?, ?)";
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(query, Types.DECIMAL, Types.VARCHAR, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);
        tacoOrder.setPlacedAt(new Date());
        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(Arrays.asList(tacoOrder.getAmount(),
                        tacoOrder.getAddress(),
                        tacoOrder.getPlacedAt()
                ));
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, generatedKeyHolder);
        long orderId = generatedKeyHolder.getKey().longValue();
        tacoOrder.setId(orderId);

        int key = 0;
        for (Taco taco : tacoOrder.getTacos()) {
            taco.setTacoOrder(orderId);
            saveTaco(taco, key++);
        }

        return tacoOrder;
    }

    private void saveTaco(Taco taco, int key) {
        String query = "insert into taco(name, taco_order, taco_order_key, created_at) values(?, ?, ?, ?)";
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(query, Types.VARCHAR, Types.INTEGER, Types.INTEGER,
                        Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(taco.getName(),
                taco.getTacoOrder(), key, taco.getCreatedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        saveIngredientRefs(tacoId, taco.getIngredients());
    }

    private void saveIngredientRefs(long tacoId, List<IngredientRef> ingredientRefs) {
        String query = "insert into ingredient_ref(taco, taco_key, ingredient) values(?, ?, ?)";
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(query, tacoId, key++, ingredientRef.getIngredient());
        }
    }


}
