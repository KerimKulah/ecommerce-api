package com.project.ecommerce.service;

import com.project.ecommerce.entity.Orderr;
import com.project.ecommerce.entity.PriceHistory;
import com.project.ecommerce.repository.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {

    @Autowired
    private  PriceHistoryRepository priceHistoryRepository;

    @Override
    public List<PriceHistory> getPriceHistoryByOrderr(Orderr orderr) {
        return priceHistoryRepository.findByOrderr(orderr);
    }

}
