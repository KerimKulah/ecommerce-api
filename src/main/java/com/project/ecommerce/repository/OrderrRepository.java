package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Orderr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderrRepository extends JpaRepository<Orderr, Long> {
    Optional<Orderr> findByOrderCode(String orderCode);
    List<Orderr> findAllByCustomer_Id(Long customerId);
}
