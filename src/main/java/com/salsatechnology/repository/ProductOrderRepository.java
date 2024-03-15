package com.salsatechnology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salsatechnology.model.ProductOrder;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query("SELECT po FROM ProductOrder po WHERE po.userName = ?1")
    List<ProductOrder> findByUserName(String userName);

}
