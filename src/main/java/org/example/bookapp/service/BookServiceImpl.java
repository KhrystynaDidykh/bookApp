package org.example.bookapp.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.example.bookapp.dto.BookDto;
import org.example.bookapp.dto.CreateBookRequestDto;
import org.example.bookapp.mapper.BookMapper;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return (List<BookDto>) bookRepository.findAll().stream()
                .map((Function<Book, BookDto>) bookMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get book with id: "
                        + id)
        );
        return bookMapper.toDto(book);
    }
}
