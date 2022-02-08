package com.dio.personapi.exception;

import com.dio.personapi.dto.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PersonNotFoundException.class})
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException e, WebRequest webRequest) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .error(e.getNAME())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
