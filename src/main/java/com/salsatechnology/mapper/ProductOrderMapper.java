package com.salsatechnology.mapper;

import com.salsatechnology.dto.ProductOrderReturnDTO;
import com.salsatechnology.model.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductOrderMapper {

    ProductOrderMapper INSTANCE = Mappers.getMapper(ProductOrderMapper.class);

    @Mappings({
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "productType", target = "productType"),
            @Mapping(source = "timeHour", target = "timeHour"),
            @Mapping(source = "productValue", target = "productValue"),
            @Mapping(source = "productTotal", target = "productTotal"),
            @Mapping(source = "userAmount", target = "userAmount")
    })
    ProductOrderReturnDTO productOrderToProductOrderReturnDTO(ProductOrder productOrder);
}
