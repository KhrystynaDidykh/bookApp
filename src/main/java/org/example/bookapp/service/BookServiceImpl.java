package org.example.bookapp.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookapp.dto.BookDto;
import org.example.bookapp.dto.BookSearchParameters;
import org.example.bookapp.dto.CreateBookRequestDto;
import org.example.bookapp.mapper.BookMapper;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.book.BookRepository;
import org.example.bookapp.repository.book.BookSpecificationBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();

    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get book with id: "
                        + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto bookDto) {
        Book bookFromDb = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't get book with id: " + id)
        );
        bookMapper.updateBookFromDto(bookDto, bookFromDb);
        Book updatedBook = bookRepository.save(bookFromDb);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    public List<BookDto> search(BookSearchParameters searchParameters, Pageable pageable) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(searchParameters);
        return bookRepository.findAll(bookSpecification, pageable)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
