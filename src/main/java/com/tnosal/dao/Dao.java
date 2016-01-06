package com.tnosal.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gohilukk on 2016-01-06.
 */
public class Dao {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> void add(T object) {
        entityManager.persist(object);
    }
}
