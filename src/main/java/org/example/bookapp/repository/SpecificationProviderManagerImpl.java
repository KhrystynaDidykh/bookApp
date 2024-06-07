package org.example.bookapp.repository;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.example.bookapp.model.Book;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpecificationProviderManagerImpl implements SpecificationProviderManager<Book> {
    private List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecification(String key) {
        return bookSpecificationProviders.stream()
                .filter(provider -> provider.getKey().equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find correct "
                                + "specification provider for key " + key));
    }
}

