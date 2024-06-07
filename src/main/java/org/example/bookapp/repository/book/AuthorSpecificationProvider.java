package org.example.bookapp.repository.book;

import java.util.Arrays;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    private static final String AUTHOR_PARAM = "author";

    @Override
    public String getKey() {
        return AUTHOR_PARAM;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root
                .get(AUTHOR_PARAM)
                .in(Arrays.stream(params)
                        .toArray());
    }
}
