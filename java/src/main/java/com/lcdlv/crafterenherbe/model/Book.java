package com.lcdlv.crafterenherbe.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
@Data
@Entity(name = "books")
public class Book {
    @Id
    private Integer id;
    private String name;
    private int price;
    @ManyToOne
    private ShoppingCart shoppingCart;

}
