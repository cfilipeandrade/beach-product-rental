package com.salsatechnology.util;

import com.salsatechnology.model.ProductOrder;

public class CommissionCalculator {

    public static long calculateCommission(ProductOrder productOrder) {
        double commissionRate;
        switch (productOrder.getProductType()) {
            case SURFBOARD:
                commissionRate = 0.156; // 15.6%
                break;
            case BEACH_CHAIR:
                commissionRate = 0.05; // 5%
                break;
            case SUNSHADE:
                commissionRate = 0.103; // 10.3%
                break;
            case SAND_BOARD:
                commissionRate = 0.09; // 9%
                break;
            case BEACH_TABLE:
                commissionRate = 0.081; // 8.1%
                break;
            default:
                commissionRate = 0; // Default to 0%
                break;
        }
        double commission = productOrder.getProductTotal() * commissionRate;
        return Math.round(commission); // Multiplica por 100 para salvar como inteiro no banco de dados
    }
}
