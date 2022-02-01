package com.dio.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person not found in the system")
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found in the system");
    }

}
