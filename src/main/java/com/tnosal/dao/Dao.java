package com.tnosal.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-06.
 */
@Transactional
public class Dao {

    private static final String QUERY_SELECT_ALL = "SELECT o FROM %s o ORDER BY o.id";

    @PersistenceContext
    private EntityManager entityManager;

    public <T> T add(T object) {
        entityManager.persist(object);
        entityManager.flush();
        return object;
    }

    public <T> List getAll(final Class<T> clazz) {
        return entityManager.createQuery(String.format(QUERY_SELECT_ALL, clazz.getSimpleName())).getResultList();
    }

    public <T, ID> T getById(final Class<T> clazz, final ID id) {
        return entityManager.find(clazz, id);
    }

    public <T> T merge(final T object) {
        return entityManager.merge(object);
    }
}
