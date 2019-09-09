package com.library.oldlibrary.service;

import com.oldlibrary.books.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private static final Map<String, Order> orders = new HashMap<String, Order>();

    @PostConstruct
    public void initialize(){
        Order order = new Order();
        order.setIsbn("1231231231");
        order.setCustomerAddress("nose 123");
        order.setCustomerLastName("juancito");
        order.setCustomerName("juan");
        order.setCustomerPhone("5645646587");

        orders.put(order.getIsbn(),order);
    }

    public Order getOrderDetail(String isbn){
        return orders.get(isbn);
    }
}
