package com.project.ecommerce.controller;

import com.project.ecommerce.entity.Orderr;
import com.project.ecommerce.entity.PriceHistory;
import com.project.ecommerce.service.OrderrService;
import com.project.ecommerce.service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pricehistory")
public class PriceHistoryController {

    @Autowired
    private PriceHistoryService priceHistoryService;

    @Autowired
    private OrderrService orderrService;

    @GetMapping("/{code}")
    public List<PriceHistory> getPriceHistory(@PathVariable String code) {
        Orderr orderr = orderrService.getOrderForCode(code);
        return priceHistoryService.getPriceHistoryByOrderr(orderr);
    }
}
