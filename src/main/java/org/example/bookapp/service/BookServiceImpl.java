package org.example.bookapp.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List findAll() {
        return bookRepository.findAll();
    }
}
