package com.kwanse.shop.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Response<T> {

    private T data;

    private String status;

    private String message;

    private Response(String status) {
        this.status = status;
    }

    private Response(T data, String status) {
        this.data = data;
        this.status = status;
    }

    private Response(String message, String status) {
        this.status = status;
        this.message = message;
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(data, "SUCCESS");
    }

    public static <T> Response<T> noContent() {
        return new Response<>("NO_CONTENT");
    }

    public static <T> Response<T> badRequest(Exception e) {
        return new Response<>(e.getMessage(), "BAD_REQUEST");
    }
}
