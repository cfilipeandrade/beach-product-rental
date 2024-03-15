package com.salsatechnology.util;

import com.salsatechnology.model.ProductOrder;

public class CommissionCalculator {

    public static long calculateCommission(ProductOrder productOrder) {
        double commissionRate;
        switch (productOrder.getProductType()) {
            case SURFBOARD:
                commissionRate = 0.156;
                break;
            case BEACH_CHAIR:
                commissionRate = 0.05;
                break;
            case SUNSHADE:
                commissionRate = 0.103;
                break;
            case SAND_BOARD:
                commissionRate = 0.09;
                break;
            case BEACH_TABLE:
                commissionRate = 0.081;
                break;
            default:
                commissionRate = 0;
                break;
        }
        double commission = productOrder.getProductTotal() * commissionRate;
        return Math.round(commission);
    }
}
