package com.dio.personapi.service;

import com.dio.personapi.dto.request.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO create(PersonDTO newPersonDTO);
    List<PersonDTO> getAll();
}
