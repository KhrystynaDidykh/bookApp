package org.example.bookapp.repository.book;

import org.example.bookapp.dto.BookSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface BookSpecificationBuilder<T> {
    Specification<T> build(BookSearchParameters bookSearchParameters);
}
