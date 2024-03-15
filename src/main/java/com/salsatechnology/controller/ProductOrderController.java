package com.salsatechnology.controller;

import javax.validation.Valid;

import com.salsatechnology.dto.ProductOrderReturnDTO;
import com.salsatechnology.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.service.ProductOrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO) {
		productOrderService.createOrder(productOrderDTO);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ProductOrderReturnDTO>> listOrders(@RequestParam(required = false) String userName) {
		if (userName != null) {
			List<ProductOrderReturnDTO> orders = productOrderService.findOrdersByUserName(userName);
			return ResponseEntity.ok(orders);
		} else {
			List<ProductOrderReturnDTO> orders = productOrderService.getAllOrders();
			return ResponseEntity.ok(orders);
		}
	}
}
