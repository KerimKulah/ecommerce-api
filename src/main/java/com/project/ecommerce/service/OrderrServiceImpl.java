package com.project.ecommerce.service;

import com.project.ecommerce.entity.*;
import com.project.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderrServiceImpl implements OrderrService {

    @Autowired
    private OrderrRepository orderrRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    private String generateOrderCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void placeOrder(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Cart cart = cartRepository.findByCustomer_Id(customerId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Orderr orderr = new Orderr();
        orderr.setCustomer(customer);
        orderr.setProducts(new ArrayList<>(cart.getProducts()));
        orderr.setTotalPrice(cart.getTotalPrice());
        orderr.setOrderCode(generateOrderCode());

        // Ürünün stoğunu güncelle
        for (Product product : cart.getProducts()) {
            if (product.getStock() <= 0) {
                throw new RuntimeException("Product out of stock: " + product.getName());
            }
            product.setStock(product.getStock() - 1);
            productRepository.save(product);
        }

        // Save order
        orderrRepository.save(orderr);

        //PriceHistory
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setOrderr(orderr);
        for (Product product : cart.getProducts()) {
            priceHistory.setProduct(product);
            priceHistory.setPrice(product.getPrice());
            priceHistoryRepository.save(priceHistory);
        }

        // Sepeti boşalt
        cart.getProducts().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);
        }

    @Override
    public Orderr getOrderForCode(String orderCode) {
        return orderrRepository.findByOrderCode(orderCode)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Orderr> getAllOrdersForCustomer(Long customerId) {
        return orderrRepository.findAllByCustomer_Id(customerId);
    }
}
