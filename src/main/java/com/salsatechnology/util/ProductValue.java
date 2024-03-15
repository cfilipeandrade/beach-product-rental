package com.salsatechnology.util;

import com.salsatechnology.dto.ProductOrderDTO;

public class ProductValue {

    public static long calculateProductValue (ProductOrderDTO productOrderDTO) {

        long productValue;
        switch (productOrderDTO.getProductType()) {
            case SURFBOARD:
                productValue = 5000; // R$50,00
                break;
            case BEACH_CHAIR:
                productValue = 3500; // R$35,00
                break;
            case SUNSHADE:
                productValue = 4000; // R$40,00
                break;
            case SAND_BOARD:
                productValue = 2500; // R$25,00
                break;
            case BEACH_TABLE:
                productValue = 2500; // R$25,00
                break;
            default:
                productValue = 0; // Valor padrão
                break;
        }

        return productValue;
    }
}
