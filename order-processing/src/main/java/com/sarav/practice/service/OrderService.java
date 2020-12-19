package com.sarav.practice.service;

import com.sarav.practice.dao.OrderDAO;
import com.sarav.practice.dto.Order;
import com.sarav.practice.exception.BusinessException;

public interface OrderService {
	
	boolean placeOrder(Order order) throws BusinessException;
	
	Order retrieveOrder(int id) throws BusinessException;
	
	boolean cancelOrder(Order order) throws BusinessException;
	
	boolean deleteOrder(int id) throws BusinessException;
	
	void setOrderDao(OrderDAO orderDao);

}
