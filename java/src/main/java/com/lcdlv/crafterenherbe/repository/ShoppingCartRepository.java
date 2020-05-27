package com.lcdlv.crafterenherbe.repository;

import com.lcdlv.crafterenherbe.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
