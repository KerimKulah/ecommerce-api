package com.project.ecommerce.service;

import com.project.ecommerce.entity.Orderr;

import java.util.List;

public interface OrderrService {
    void placeOrder(Long customerId);
    Orderr getOrderForCode(String orderCode);
    List<Orderr> getAllOrdersForCustomer(Long customerId);
}
