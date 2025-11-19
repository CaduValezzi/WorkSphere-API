package br.com.worksphere.core.dto;

import java.time.Instant;

public record ApiResponse<T>(
        String message,
        T data,
        Instant timestamp
) {
    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(message, data, Instant.now());
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(message, data, Instant.now());
    }
}
