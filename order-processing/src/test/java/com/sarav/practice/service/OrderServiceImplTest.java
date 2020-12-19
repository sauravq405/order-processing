package com.sarav.practice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sarav.practice.dao.OrderDAO;
import com.sarav.practice.dto.Order;
import com.sarav.practice.exception.BusinessException;

class OrderServiceImplTest {
    @Mock
 	OrderDAO orderDao;
    private OrderService service;
    private Order order; 
    
    @BeforeEach
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    	service = new OrderServiceImpl();
    	service.setOrderDao(orderDao);
    	order = new Order();
    }
    
    @Test
    void shouldPlaceAnOrder() throws BusinessException, SQLException {
    	when(orderDao.create(order)).thenReturn(1);    	
		boolean result = service.placeOrder(order);
    	assertTrue(result);
    	verify(orderDao).create(order);
    }
    
	@Test
    void shouldThrowException_whilePlacingOrder() throws SQLException {
    	when(orderDao.create(order)).thenThrow(SQLException.class);
    	assertThrows(BusinessException.class, () -> {
    		service.placeOrder(order);
    	});
    	verify(orderDao).create(order);
    }
    
}
