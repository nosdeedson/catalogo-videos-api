package com.E3N.domain.genre;

import com.E3N.domain.pagination.Pagination;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GenreGateway {

    Genre save(final Genre genre);

    void deleteById(final String id);

    Optional<Genre> findById(final String id);

    List<Genre> findAllById(Set<String> ids);

    Pagination<Genre> findAll(GenreSearchQuery query);
}
