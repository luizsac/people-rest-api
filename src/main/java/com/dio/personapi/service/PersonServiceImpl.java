package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        var savedPerson = personRepository.save(personMapper.toModel(personDTO));
        return personMapper.toDTO(savedPerson);
    }

    @Override
    public List<PersonDTO> getAll() {
        return null;
    }

}
