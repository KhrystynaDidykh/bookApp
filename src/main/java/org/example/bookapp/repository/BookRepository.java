package org.example.bookapp.repository;

import java.util.List;
import org.example.bookapp.model.Book;

public interface BookRepository {
    Book save(Book book);

    List findAll();
}
