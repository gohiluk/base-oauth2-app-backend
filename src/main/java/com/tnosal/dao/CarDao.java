package com.tnosal.dao;

import com.tnosal.domain.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-06.
 */
@Repository
@Transactional
public class CarDao extends Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Car> getAllByUserId(Long id) {
        return entityManager.createQuery("SELECT i from Car i where i.user.id = :user_id", Car.class)
                .setParameter("user_id", id).getResultList();
    }
}
