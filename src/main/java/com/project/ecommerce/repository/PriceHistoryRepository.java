package com.project.ecommerce.repository;

import com.project.ecommerce.entity.Orderr;
import com.project.ecommerce.entity.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    List<PriceHistory> findByOrderr(Orderr orderr);
}

