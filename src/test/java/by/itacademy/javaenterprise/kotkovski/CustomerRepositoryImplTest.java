package by.itacademy.javaenterprise.kotkovski;

import by.itacademy.javaenterprise.kotkovski.dao.CustomerRepository;
import by.itacademy.javaenterprise.kotkovski.dao.impl.CustomerRepositoryImpl;
import by.itacademy.javaenterprise.kotkovski.entity.Customer;
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
public class CustomerRepositoryImplTest {
    @Mock
    private EntityTransaction entityTransactionMock;
    @Mock
    private EntityManager entityManagerMock;
    private CustomerRepository customerRepository;

    @BeforeEach
    void beforeEach() {
        customerRepository = new CustomerRepositoryImpl(entityManagerMock);
    }

    @Test
    void saveTest() {
        Customer customer = new Customer();
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        Customer customer1 = customerRepository.save(customer);
        verify(entityManagerMock, times(1)).persist(customer);
        assertNotNull(customer1);
        assertEquals(customer, customer1);
    }

    @Test
    void findTest() {
        Integer queryId = 1;
        Customer customer = new Customer();
        customer.setId(queryId);
        Class<Customer> anyObject = Mockito.any();
        Integer eqValue = Mockito.eq(queryId);
        when(entityManagerMock.find(anyObject, eqValue)).thenReturn(customer);
        assertEquals(queryId, customerRepository.findById(queryId).getId());
    }

    @Test
    void findTestWithWrongId() {
        Integer queryId = -1;
        assertNull(customerRepository.findById(queryId));
    }
}
