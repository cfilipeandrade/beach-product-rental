package com.salsatechnology.util;

import com.salsatechnology.dto.ProductOrderDTO;

public class ProductValue {

    public static long calculateProductValue (ProductOrderDTO productOrderDTO) {

        long productValue;
        switch (productOrderDTO.getProductType()) {
            case SURFBOARD:
                productValue = 5000;
                break;
            case BEACH_CHAIR:
                productValue = 3500;
                break;
            case SUNSHADE:
                productValue = 4000;
                break;
            case SAND_BOARD:
                productValue = 2500;
                break;
            case BEACH_TABLE:
                productValue = 2500;
                break;
            default:
                productValue = 0;
                break;
        }

        return productValue;
    }
}
