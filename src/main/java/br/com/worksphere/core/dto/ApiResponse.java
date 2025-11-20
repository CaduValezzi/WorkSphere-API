package br.com.worksphere.core.dto;

import java.time.Instant;

public class ApiResponse<T> {

    private String message;
    private T data;
    private Instant timestamp;

    public ApiResponse(String message, T data, Instant timestamp) {
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(message, data, Instant.now());
    }

    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(message, data, Instant.now());
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
