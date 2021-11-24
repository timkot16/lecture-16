package by.itacademy.javaenterprise.kotkovski;

import by.itacademy.javaenterprise.kotkovski.dao.CarRepository;
import by.itacademy.javaenterprise.kotkovski.dao.CustomerRepository;
import by.itacademy.javaenterprise.kotkovski.dao.impl.CarRepositoryImpl;
import by.itacademy.javaenterprise.kotkovski.dao.impl.CustomerRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateRunner {
    private static final Logger logger = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("serviceBook");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();
        CarRepository carRepository =
                new CarRepositoryImpl(entityManager);
        CustomerRepository customerRepository =
                new CustomerRepositoryImpl(entityManager);
        customerRepository.findById(3);
        logger.info(customerRepository.toString());
        carRepository.findById(1);
        logger.info(carRepository.toString());
    }
}
