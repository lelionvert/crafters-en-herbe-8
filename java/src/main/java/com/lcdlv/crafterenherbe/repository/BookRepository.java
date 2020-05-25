package com.lcdlv.crafterenherbe.repository;

import com.lcdlv.crafterenherbe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
