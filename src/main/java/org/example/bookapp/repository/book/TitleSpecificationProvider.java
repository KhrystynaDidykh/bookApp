package org.example.bookapp.repository.book;

import java.util.Arrays;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    private static final String SECONDPARAM = "title";

    @Override
    public String getKey() {
        return SECONDPARAM;
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get("title").in(Arrays.stream(params)
                .toArray());
    }
}
