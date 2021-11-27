package by.itacademy.javaenterprise.kotkovski.dao.impl;

import by.itacademy.javaenterprise.kotkovski.dao.CarRepository;
import by.itacademy.javaenterprise.kotkovski.dao.exception.DAOException;
import by.itacademy.javaenterprise.kotkovski.entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class CarRepositoryImpl implements CarRepository {
    private static final Logger logger = LoggerFactory.getLogger(CarRepositoryImpl.class);

    private final EntityManager entityManager;

    public CarRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Car save(Car car) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(car);
            entityManager.getTransaction().commit();
            return car;
        } catch (Exception e) {
            logger.error("Error from CarRepositoryImpl in method save", e);
            entityManager.getTransaction().rollback();
            throw new DAOException(e);
        }
    }

    @Override
    public Car findById(Integer id) {
        Car car;
        try {
            car = entityManager.find(Car.class, id);
            return car;
        } catch (Exception e) {
            logger.error("Error from CarRepositoryImpl in method findById", e);
            throw new DAOException(e);
        }
    }
}
