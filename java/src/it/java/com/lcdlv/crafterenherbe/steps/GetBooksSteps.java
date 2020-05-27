package com.lcdlv.crafterenherbe.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcdlv.crafterenherbe.CrafterEnHerbeApplication;
import com.lcdlv.crafterenherbe.model.Book;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CrafterEnHerbeApplication.class})
public class GetBooksSteps implements En {
    private MockHttpServletResponse response;
    private static final String BOOKS_END_POINT = "/books";

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    public GetBooksSteps() {
        Before(() -> {
            mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        });
        When("^client want to see all books available$", () -> {
            response = mockMvc.perform(MockMvcRequestBuilders.get(BOOKS_END_POINT))
                    .andDo(print())
                    .andReturn()
                    .getResponse();
        });

        Then("^api should display the following books$", (DataTable booksDataTable) -> {
            Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

            Book[] expectedBooks = booksDataTable.asList(Book.class)
                    .toArray(new Book[booksDataTable.asList(Book.class).size()]);

            List<Book> actualBooks = new ObjectMapper().readValue(response.getContentAsString(), new TypeReference<>() {
            });

            Assertions.assertThat(actualBooks).containsExactlyInAnyOrder(expectedBooks);
        });

        DataTableType((Map<String, String> row) ->
                Book.builder()
                        .id(Integer.parseInt(row.get("id")))
                        .name(row.get("name"))
                        .price(Integer.parseInt(row.get("price")))
                        .build());
    }
}
