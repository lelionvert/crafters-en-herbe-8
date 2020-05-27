package com.lcdlv.crafterenherbe.controller;

import com.lcdlv.crafterenherbe.model.Book;
import com.lcdlv.crafterenherbe.model.ShoppingCart;
import com.lcdlv.crafterenherbe.repository.BookRepository;
import com.lcdlv.crafterenherbe.repository.ShoppingCartRepository;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Api(tags = "shoppingCart")
@RestController
@RequestMapping("/")
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping(value = "/cart")
    public ResponseEntity<ShoppingCart> getShoppingCart() {
        Optional<ShoppingCart> cart = shoppingCartRepository.findAll().stream().findFirst();
        return cart.map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }
}
