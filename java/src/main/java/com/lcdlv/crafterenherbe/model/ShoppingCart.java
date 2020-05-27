package com.lcdlv.crafterenherbe.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Entity(name = "shopping_cart")
public class ShoppingCart {
    @Id
    private Integer id;
    @OneToMany
    private List<Book> Books;
}
