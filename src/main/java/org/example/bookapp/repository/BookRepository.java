package org.example.bookapp.repository;

import java.util.List;
import java.util.Optional;
import org.example.bookapp.model.Book;

public interface BookRepository {
    Book save(Book book);

    List findAll();

    Optional<Book> findById(Long id);
}
