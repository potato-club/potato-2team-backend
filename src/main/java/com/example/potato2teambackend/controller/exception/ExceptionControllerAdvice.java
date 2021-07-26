package com.example.potato2teambackend.controller.exception;

import com.example.potato2teambackend.controller.ApiResponse;
import com.example.potato2teambackend.exception.ConflictException;
import com.example.potato2teambackend.exception.NotFoundException;
import com.example.potato2teambackend.exception.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("BAD_REQUEST", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Object> missingRequestHeaderException(MissingRequestHeaderException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("BAD_REQUEST", e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Object> notFoundException(NotFoundException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("NOT_FOUND_EXCEPTION", e.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiResponse<Object> conflictException(ConflictException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("CONFLICT_EXCEPTION", e.getMessage());
    }

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse<Object> unAuthorizationException(UnAuthorizedException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("UNAUTHORIZATION_EXCEPTION", e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Object> notFoundException(RuntimeException e) {
        log.error(String.format("%s", e));
        return ApiResponse.error("RUN_TIME_EXCEPTION", e.getMessage());
    }

}
