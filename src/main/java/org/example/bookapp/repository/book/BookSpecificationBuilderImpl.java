package org.example.bookapp.repository.book;

import lombok.RequiredArgsConstructor;
import org.example.bookapp.dto.BookSearchParameters;
import org.example.bookapp.model.Book;
import org.example.bookapp.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilderImpl implements BookSpecificationBuilder<Book> {
    private static final String FIRSTPARAM = "author";
    private static final String SECONDPARAM = "title";
    private SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = Specification.where(null);
        if (bookSearchParameters.authors() != null && bookSearchParameters.authors().length > 0) {
            specification = specification
                    .and(specificationProviderManager.getSpecification(FIRSTPARAM)
                            .getSpecification(bookSearchParameters.authors()));
        }
        if (bookSearchParameters.titles() != null && bookSearchParameters.titles().length > 0) {
            specification = specification
                    .and(specificationProviderManager.getSpecification(SECONDPARAM)
                            .getSpecification(bookSearchParameters.titles()));
        }
        return specification;
    }
}
