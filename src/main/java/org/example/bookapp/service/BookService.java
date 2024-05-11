package org.example.bookapp.service;

import java.util.List;
import org.example.bookapp.model.Book;

public interface BookService {
    Book save(Book book);

    List findAll();
}
