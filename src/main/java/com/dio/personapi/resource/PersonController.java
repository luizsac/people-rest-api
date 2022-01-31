package com.dio.personapi.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Well, Hello!", HttpStatus.OK);
    }

}