package com.tnosal.dao;

import com.tnosal.model.Authority;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by gohilukk on 2015-12-13.
 */
@Repository
@Transactional
public class AuthorityDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public Optional<Long> getAuthorityIdByName(String name) {
        Criteria criteria = getSessionFactory().createCriteria(Authority.class);
        criteria.add(Expression.eq("name", name));
        List list = criteria.list();
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(((Authority)list.get(0)).getId());
    }
}
