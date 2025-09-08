package com.janz.job_tracker.models;

import lombok.Getter;
import lombok.Setter;

public class ApiResponse<T> {
    private final String message;
    private final T data;

    private ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static class Builder<T> {
        private String message = "";
        private T data;

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(message, data);
        }
    }
}