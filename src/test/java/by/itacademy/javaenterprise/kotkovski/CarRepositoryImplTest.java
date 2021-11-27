package by.itacademy.javaenterprise.kotkovski;

import by.itacademy.javaenterprise.kotkovski.dao.impl.CarRepositoryImpl;
import by.itacademy.javaenterprise.kotkovski.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarRepositoryImplTest {
    @Mock
    private EntityTransaction entityTransactionMock;
    @Mock
    private EntityManager entityManagerMock;
    private CarRepositoryImpl carRepository;

    @BeforeEach
    void beforeEach() {
        carRepository = new CarRepositoryImpl(entityManagerMock);
    }

    @Test
    void saveTest() {
        Car car = new Car();
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        Car car1 = carRepository.save(car);
        verify(entityManagerMock, times(1)).persist(car);
        assertNotNull(car1);
        assertEquals(car, car1);
    }

    @Test
    void findTest() {
        Integer queryId = 1;
        Car car = new Car();
        car.setId(queryId);
        Class<Car> anyObject = Mockito.any();
        Integer eqValue = Mockito.eq(queryId);
        when(entityManagerMock.find(anyObject, eqValue)).thenReturn(car);
        assertEquals(queryId, carRepository.findById(queryId).getId());
    }

    @Test
    void findTestWithWrongId() {
        Integer queryId = -1;
        assertNull(carRepository.findById(queryId));
    }
}
