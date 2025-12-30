package com.kh.commu.global.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice // 애플리케이션 전체의 Controller 에서 발생하는 예외를 처라하겠다.
public class GlobalExceptionHandler {
    
    //@Valid 검증 실패
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
           String fieldName = ((FieldError)error).getField();
           String errorMessage = error.getDefaultMessage();
           errors.put(fieldName, errorMessage);
        });

        ErrorResponse response = ErrorResponse.error("입력값 검증에 실패하셨습니다.", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //@Validated 검증 실패 시 발생 (PathVariable, RequestParam)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage,
                        (existingValue, newValue) -> existingValue
                ));

        ErrorResponse response = ErrorResponse.error("입력값 검증에 실패하셨습니다.", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = ErrorResponse.of(e.getMessage());
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
