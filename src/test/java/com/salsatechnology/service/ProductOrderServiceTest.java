package com.salsatechnology.service;

import static org.junit.jupiter.api.Assertions.*;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.dto.ProductOrderReturnDTO;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.ProductOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class ProductOrderServiceTest {

    @Mock
    private ProductOrderRepository productOrderRepository;

    @InjectMocks
    private ProductOrderService productOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createOrder_Success() {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setUserName("testUser");
        productOrderDTO.setProductType(ProductType.SURFBOARD);
        productOrderDTO.setTimeHour(2);

        when(productOrderRepository.save(any())).thenReturn(new ProductOrder());

        assertDoesNotThrow(() -> productOrderService.createOrder(productOrderDTO));
    }

    @Test
    void findOrdersByUserName_Success() {
        String userName = "testUser";
        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(new ProductOrder());
        productOrders.add(new ProductOrder());

        when(productOrderRepository.findByUserName(userName)).thenReturn(productOrders);

        List<ProductOrderReturnDTO> orders = productOrderService.findOrdersByUserName(userName);

        assertNotNull(orders);
        assertEquals(2, orders.size());
    }

    @Test
    void getAllOrders_Success() {
        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(new ProductOrder());
        productOrders.add(new ProductOrder());

        when(productOrderRepository.findAll()).thenReturn(productOrders);

        List<ProductOrderReturnDTO> orders = productOrderService.getAllOrders();

        assertNotNull(orders);
        assertEquals(2, orders.size());
    }
}