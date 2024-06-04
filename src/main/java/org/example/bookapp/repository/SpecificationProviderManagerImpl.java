package org.example.bookapp.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.bookapp.model.Book;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SpecificationProviderManagerImpl implements SpecificationProviderManager<Book> {
    private List<SpecificationProvider<Book>> specificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecification(String key) {
        return specificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't find correct specification provider for key "
                                + key));

    }
}

