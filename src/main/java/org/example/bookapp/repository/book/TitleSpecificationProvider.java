package org.example.bookapp.repository.book;

import java.util.Arrays;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    private static final String TITLE_PARAM = "title";

    @Override
    public String getKey() {
        return TITLE_PARAM;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get(TITLE_PARAM).in(Arrays.stream(params)
                .toArray());
    }
}
