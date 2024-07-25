package com.project.ecommerce.service;
import com.project.ecommerce.entity.Orderr;
import com.project.ecommerce.entity.PriceHistory;

import java.util.List;

public interface PriceHistoryService {
    List<PriceHistory> getPriceHistoryByOrderr(Orderr orderr);
}

