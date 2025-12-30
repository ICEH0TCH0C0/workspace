package com.kh.commu.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //json 직렬화 시 null인 값을 포함 X
public class ErrorResponse {
    private final String message;
    private final boolean success;
    private final Map<String, String> errors;

    @Builder.Default //항상 현재 시간이 Db에 저장
    private final LocalDateTime timestamp = LocalDateTime.now();

    public static ErrorResponse of(String message) {
        return ErrorResponse.builder()
                .success(false)
                .message(message)
                .build();
    }

    public static ErrorResponse error(String message, Map<String, String> errors) {
        return ErrorResponse.builder()
                .success(false)
                .message(message)
                .errors(errors)
                .build();
    }
}
