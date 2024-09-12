package com.abhijeet.redistry.service;

import com.abhijeet.redistry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findByName(String name) {
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        JpaCriteriaQuery<User> cq = criteriaBuilder.createQuery(User.class);
        JpaRoot<User> root = cq.from(User.class);
        cq.select(root).where(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
        Query<User> query = session.createQuery(cq);
        return query.getResultList();
    }
}
