package com.E3N.domain.pagination;

public record Metadata(
        int currentPage,
        int perPage,
        long total
) {
}
