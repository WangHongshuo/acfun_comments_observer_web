package org.acfun.comments.observer.web.backend.entity;

import lombok.Data;

@Data
public class RestBean<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

    private RestBean(int code, boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(200, true, null, null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, true, null, data);
    }

    public static <T> RestBean<T> success(String message, T data) {
        return new RestBean<>(200, true, message, data);
    }

    public static <T> RestBean<T> failure(int code) {
        return new RestBean<>(code, false, null, null);
    }

    public static <T> RestBean<T> failure(int code, String message) {
        return new RestBean<>(code, false, message, null);
    }
}
