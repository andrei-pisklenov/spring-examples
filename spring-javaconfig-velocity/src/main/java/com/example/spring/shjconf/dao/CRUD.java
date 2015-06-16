package com.example.spring.shjconf.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Useful generic component for Create, Read, Update and Delete operations with entities
 */
@Component
public class CRUD {
    @Autowired
    private SessionFactory sessionFactory;

    public <T> T save(final T o) {
        return (T) session().save(o);
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    public void delete(final Object object) {
        session().delete(object);
    }

    public <T> T get(final Class<T> type, final Long id) {
        return (T) session().get(type, id);
    }

    public <T> T merge(final T o) {
        return (T) session().merge(o);
    }

    public <T> void saveOrUpdate(final T o) {
        session().saveOrUpdate(o);
    }

    public <T> List<T> getAll(final Class<T> type) {
        Criteria crit = session().createCriteria(type);
        return crit.list();
    }
}
