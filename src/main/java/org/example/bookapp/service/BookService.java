package org.example.bookapp.service;

import java.util.List;
import org.example.bookapp.dto.BookDto;
import org.example.bookapp.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    List<BookDto> findAll();

    BookDto findById(Long id);

    void deleteById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto bookDto);
}
