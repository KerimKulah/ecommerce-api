package com.project.ecommerce.service;

import com.project.ecommerce.entity.Cart;
import com.project.ecommerce.entity.Customer;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addCustomer(Customer customer) {
        // Önce müşteri nesnesini kaydediyoruz
        customerRepository.save(customer);

        // Sepeti oluşturup müşteriye atıyoruz
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setTotalPrice(0);

        // Sepeti kaydediyoruz
        cartRepository.save(cart);

        // Müşterinin sepet referansını güncelliyoruz
        customer.setCart(cart);

        // Müşteriyi tekrar güncelliyoruz
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
