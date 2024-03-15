package com.salsatechnology.service;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.dto.ProductOrderReturnDTO;
import com.salsatechnology.mapper.ProductOrderMapper;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.ProductOrderRepository;
import com.salsatechnology.util.CommissionCalculator;
import com.salsatechnology.util.ProductValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

	private final ProductOrderRepository productOrderRepository;

	@Autowired
	public ProductOrderService(ProductOrderRepository productOrderRepository) {
		this.productOrderRepository = productOrderRepository;
	}

	@Transactional
	public void createOrder(ProductOrderDTO productOrderDTO) {
		try {
			ProductOrder productOrder = createProductOrder(productOrderDTO);
			productOrderRepository.save(productOrder);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao criar pedido: " + e.getMessage());
		}
	}

	public List<ProductOrderReturnDTO> findOrdersByUserName(String userName) {
		try {
			List<ProductOrder> productOrderList = productOrderRepository.findByUserName(userName);
			return productOrderList.stream()
					.map(ProductOrderMapper.INSTANCE::productOrderToProductOrderReturnDTO)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Falha ao encontrar pedidos por username: " + e.getMessage());
		}
	}

	public List<ProductOrderReturnDTO> getAllOrders() {
		try {
			List<ProductOrder> productOrderList = productOrderRepository.findAll();
			return productOrderList.stream()
					.map(ProductOrderMapper.INSTANCE::productOrderToProductOrderReturnDTO)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Falha ao recuperar todos os pedidos: " + e.getMessage());
		}
	}

	private ProductOrder createProductOrder(ProductOrderDTO productOrderDTO) {
		try {
			ProductOrder productOrder = new ProductOrder();
			long productValue = ProductValue.calculateProductValue(productOrderDTO);
			long productTotal = productOrderDTO.getTimeHour() * productValue;

			productOrder.setUserName(productOrderDTO.getUserName());
			productOrder.setProductType(productOrderDTO.getProductType());
			productOrder.setTimeHour(productOrderDTO.getTimeHour());
			productOrder.setProductValue(productValue);
			productOrder.setProductTotal(productTotal);

			long commission = CommissionCalculator.calculateCommission(productOrder);
			productOrder.setUserAmount(commission);

			return productOrder;
		} catch (Exception e) {
			throw new RuntimeException("Falha ao criar pedido de produto: " + e.getMessage());
		}
	}
}
