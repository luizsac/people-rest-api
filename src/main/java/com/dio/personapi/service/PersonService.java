package com.dio.personapi.service;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;

import java.util.List;

public interface PersonService {

    PersonDTO create(PersonDTO newPersonDTO);
    List<PersonDTO> getAll();
    PersonDTO getById(Long id) throws PersonNotFoundException;
    PersonDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException;
    PersonDTO delete(Long id) throws PersonNotFoundException;
}
