package com.tnosal.dao;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.tnosal.domain.Car;
import com.tnosal.domain.QService;
import com.tnosal.domain.Service;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-26.
 */
@Repository
@Transactional
public class ServiceDao extends Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public Service addWithCarId(Service service, Long carId) {
        service.setCar(entityManager.getReference(Car.class, carId));
        entityManager.persist(service);
        entityManager.flush();
        return service;
    }


    public List<Service> getAllByCarId(Long carId) {
        QService service = QService.service;
        JPQLQuery query = new JPAQuery(entityManager);
        List<Service> services = query.from(service)
                .where(service.car.id.eq(carId))
                .orderBy(service.serviceDate.asc())
                .list(service);
        return services;
    }
}
