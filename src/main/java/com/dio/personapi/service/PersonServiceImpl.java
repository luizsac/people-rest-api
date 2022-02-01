package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        var people = personRepository.findAll();
        return people
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getById(Long id) throws PersonNotFoundException {
        return personMapper.toDTO(verifyIfExists(id));
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);
        return personMapper.toDTO(savedPerson);
    }

    @Override
    public PersonDTO delete(Long id) throws PersonNotFoundException {
        Person deletedPerson = verifyIfExists(id);
        personRepository.delete(deletedPerson);
        return personMapper.toDTO(deletedPerson);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

}
