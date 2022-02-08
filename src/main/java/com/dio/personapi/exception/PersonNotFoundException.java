package com.dio.personapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@Getter
public class PersonNotFoundException extends NoSuchElementException {

    private final String NAME = "Person Not Found";

    public PersonNotFoundException() {
        super("Person with requested id was not found in the system");
    }

}
