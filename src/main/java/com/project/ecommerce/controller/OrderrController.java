package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Orderr;
import com.project.ecommerce.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderrController {

    @Autowired
    private OrderrService orderrService;

    @PostMapping("/placeOrder/{customerId}") //customerid -> müşterinin sepeti
    public String placeOrder(@PathVariable Long customerId) {
        orderrService.placeOrder(customerId);
        return "siparis olusturuldu.";
    }

    @GetMapping("/{orderCode}")
    public Orderr getOrderForCode(@PathVariable String orderCode) {
        return orderrService.getOrderForCode(orderCode);
    }

    @GetMapping("/getAllOrdersForCustomer/{customerId}")
    public List<Orderr> getAllOrdersForCustomer(@PathVariable Long customerId) {
        return orderrService.getAllOrdersForCustomer(customerId);
    }


}
