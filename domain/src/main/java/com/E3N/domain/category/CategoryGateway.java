package com.E3N.domain.category;

import com.E3N.domain.pagination.Pagination;

import java.util.List;
import java.util.Optional;

public interface CategoryGateway {

    Category save(Category category);

    void delete(String id);

    Optional<Category> findById(String id);

    List<Category> findAllById(List<String> ids);

    Pagination<Category> findAll(CategorySearchQuery query);
}
