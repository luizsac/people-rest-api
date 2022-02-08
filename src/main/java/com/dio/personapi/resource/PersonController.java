package com.dio.personapi.resource;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor
@Api(value = "Registers people")
public class PersonController {

    private final String PATH = "/api/v1/people";
    private final PersonService personService;

    @PostMapping
    @ApiOperation(value = "Creates new person in the system")
    @ApiResponse(code = 201, message = "Returns created person")
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
        return new ResponseEntity<>(personService.create(personDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "List all people records found in the system")
    @ApiResponse(code = 200, message = "Returns list of all registered people")
    public ResponseEntity<List<PersonDTO>> listAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get specified person in the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns specified person"),
            @ApiResponse(code = 404, message = "Returns message from PersonNotFoundException")
    })
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Updates specified person's attributes in the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns person with updated attributes"),
            @ApiResponse(code = 404, message = "Returns message from PersonNotFoundException")
    })
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.update(id, personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletes specified person in the system")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Returns deleted person"),
            @ApiResponse(code = 404, message = "Returns message from PersonNotFoundException")
    })
    public ResponseEntity<PersonDTO> delete(@PathVariable Long id) throws PersonNotFoundException {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }

}