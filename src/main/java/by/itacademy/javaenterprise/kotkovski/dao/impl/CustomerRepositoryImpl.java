package by.itacademy.javaenterprise.kotkovski.dao.impl;

import by.itacademy.javaenterprise.kotkovski.dao.CustomerRepository;
import by.itacademy.javaenterprise.kotkovski.dao.exception.DAOException;
import by.itacademy.javaenterprise.kotkovski.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            logger.error("Error from CustomerRepositoryImpl in method save", e);
            entityManager.getTransaction().rollback();
            throw new DAOException(e);
        }
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer;
        try {
            customer = entityManager.find(Customer.class, id);
            return customer;
        } catch (Exception e) {
            logger.error("Error from CustomerRepositoryImpl in method findById", e);
            throw new DAOException(e);
        }
    }
}
