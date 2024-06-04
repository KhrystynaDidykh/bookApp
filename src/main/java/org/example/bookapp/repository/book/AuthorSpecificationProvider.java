package org.example.bookapp.repository.book;

import java.util.Arrays;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {

    @Override
    public String getKey() {
        return "author";
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root
                .get("author")
                .in(Arrays.stream(params)
                        .toArray());
    }
}
