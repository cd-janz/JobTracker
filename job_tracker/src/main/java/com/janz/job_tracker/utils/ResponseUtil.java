package com.janz.job_tracker.utils;

import com.janz.job_tracker.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseUtil {
    private ResponseUtil() {}
    public static ResponseEntity<ApiResponse<Void>> ok() {
        return ResponseEntity.ok(new ApiResponse.Builder<Void>().message("OK").build());
    }

    public static ResponseEntity<ApiResponse<Void>> ok(String message) {
        return ResponseEntity.ok(new ApiResponse.Builder<Void>().message(message).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(String message, T data) {
        return ResponseEntity.ok(new ApiResponse.Builder<T>().data(data).message(message).build()
        );
    }

    public static <T> ResponseEntity<ApiResponse<T>> ok(T data) {
        return ResponseEntity.ok(new ApiResponse.Builder<T>().data(data).message("OK").build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, T data) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse.Builder<T>().data(data).message(message).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status, T data) {
        return ResponseEntity.status(status).body(new ApiResponse.Builder<T>().data(data).message(message).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(T data, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse.Builder<T>().data(data).build());
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse.Builder<T>().message(message).build());
    }

}