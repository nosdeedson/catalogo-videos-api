package com.E3N.domain.utils;

import java.util.UUID;

public class IdUtils {
    private IdUtils() {
    }

    public static String uniqueId() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
