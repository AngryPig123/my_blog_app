package com.rest.blog.myblogapp.exception;

import com.rest.blog.myblogapp.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final LocalDateTime now = LocalDateTime.now();

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerResourceNotFoundException(
            ResourceNotFoundException exception,
            WebRequest webRequest
    ) {
        return new ResponseEntity<>(
                ErrorDetails.builder()
                        .timeStamp(now)
                        .message(exception.getMessage())
                        .details(webRequest.getDescription(false))
                        .build()
                , HttpStatus.NOT_FOUND);
    }

}
