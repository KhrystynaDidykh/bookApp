package org.example.bookapp.repository;

public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecification(String key);
}
