package com.dio.personapi.resource;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
        return new ResponseEntity<>(personService.create(personDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.update(id, personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDTO> delete(@PathVariable Long id) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }

}