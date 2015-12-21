package com.tnosal.dao;

import com.tnosal.domain.Authority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by gohilukk on 2015-12-13.
 */
@Repository
@Transactional
public class AuthorityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Long> getAuthorityIdByName(String name) {
        return Optional.of(entityManager.createQuery("SELECT i from Authority i where i.name = :name", Authority.class)
                .setParameter("name", name)
                .getSingleResult().getId());
    }

    public Optional<Authority> getAuthorityByName(String name) {
        return Optional.of(entityManager.createQuery("SELECT i from Authority i where i.name = :name", Authority.class)
                .setParameter("name", name)
                .getSingleResult());
    }
}
