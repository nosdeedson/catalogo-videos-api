package com.E3N.domain.video;

import com.E3N.domain.pagination.Pagination;

import java.util.Optional;

public interface VideoGateway {

    Video save(final Video video);

    void deleteById(final String id);

    Optional<Video> findById(final String id);

    Pagination<Video> findAll(final VideoSearchQuery query);
}
