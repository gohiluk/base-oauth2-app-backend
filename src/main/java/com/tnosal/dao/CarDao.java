package com.tnosal.dao;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.tnosal.domain.Car;
import com.tnosal.domain.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.tnosal.domain.QCar;

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

    public Car getCarByIdAndUserId(Long id, Long userId) {
        QCar car = QCar.car;
        JPQLQuery query = new JPAQuery(entityManager);
        Car c = query.from(car)
                .where(car.id.eq(id))
                .where(car.user.id.eq(userId))
                .uniqueResult(car);
        return c;
    }
}
