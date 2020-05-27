package com.lcdlv.crafterenherbe;

import com.lcdlv.crafterenherbe.model.Book;
import com.lcdlv.crafterenherbe.repository.BookRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.lcdlv.crafterenherbe"})
@EnableJpaRepositories(basePackages = {"com.lcdlv.crafterenherbe.repository"})
@EntityScan(basePackages = {"com.lcdlv.crafterenherbe.model"})
public class CrafterEnHerbeApplication {

    private final BookRepository bookRepository;

    public CrafterEnHerbeApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrafterEnHerbeApplication.class, args);


    }

    @Bean
    InitializingBean initializeBooks() {
        return () -> {
            List<Book> books = new ArrayList<>();
            books.add(new Book(1, "The Philosopher's Stone", 10, null));
            books.add(new Book(2, "The Chamber of Secrets", 10, null));
            books.add(new Book(3, "The Prisoner of Azkaban", 10, null));
            books.add(new Book(4, "The Goblet of Fire", 10, null));
            books.add(new Book(5, "The Order of the Phoenix", 10, null));
            books.add(new Book(6, "The Half-Blood Prince", 10, null));
            books.add(new Book(7, "The Deathly Hallows", 10, null));
            bookRepository.saveAll(books);
        };
    }
}
