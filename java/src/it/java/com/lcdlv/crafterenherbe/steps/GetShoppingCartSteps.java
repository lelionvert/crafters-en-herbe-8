package com.lcdlv.crafterenherbe.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcdlv.crafterenherbe.model.Book;
import com.lcdlv.crafterenherbe.model.ShoppingCart;
import com.lcdlv.crafterenherbe.repository.ShoppingCartRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class GetShoppingCartSteps implements En {
    private static final String SHOPPING_CART_END_POINT = "/cart";
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private WebApplicationContext context;

    private MockHttpServletResponse response;

    private MockMvc mockMvc;

    public GetShoppingCartSteps() {
        Before(() -> {
            mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        });
        Given("^the following book are present in a client shopping cart$", (DataTable booksDataTable) -> {
            List<Book> bookToSave = booksDataTable.asList(Book.class);
            ShoppingCart shoppingCartToSave = ShoppingCart.builder()
                    .id(1)
                    .Books(bookToSave)
                    .build();

            ShoppingCart saved = shoppingCartRepository.save(shoppingCartToSave);

            Book[] books = bookToSave.toArray(new Book[booksDataTable.asList(Book.class).size()]);
            Assertions.assertThat(saved.getBooks()).containsExactlyInAnyOrder(books);
        });

        When("^client want to see his shopping cart$", () -> {
            response = mockMvc.perform(MockMvcRequestBuilders.get(SHOPPING_CART_END_POINT))
                    .andDo(print())
                    .andReturn()
                    .getResponse();
        });

        Then("^api should display a shopping cart with the following books$", (DataTable booksDataTable) -> {
            Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

            Book[] expectedBooks = booksDataTable.asList(Book.class).toArray(new Book[booksDataTable.asList(Book.class).size()]);
            ShoppingCart actualShoppingCart = new ObjectMapper().readValue(response.getContentAsString(), ShoppingCart.class);

            Assertions.assertThat(actualShoppingCart.getBooks()).containsExactlyInAnyOrder(expectedBooks);
        });
    }
}
