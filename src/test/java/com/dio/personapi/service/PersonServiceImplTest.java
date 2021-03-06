package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

    @Mock
    PersonRepository personRepository;

    @Mock
    PersonMapper personMapper;

    @InjectMocks
    PersonServiceImpl personService;

    @Test
    void givenPersonDTO_whenCreate_thenReturnSavedPersonDTO() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = PersonUtils.createFakeEntity();
        Person savedPerson = PersonUtils.createFakeEntity();
        PersonDTO expectedSavedPersonDTO = PersonUtils.createFakeDTO();

        expectedSavedPersonDTO.setId(savedPerson.getId());

        when(personMapper.toModel(any(PersonDTO.class))).thenReturn(person);
        when(personRepository.save(any(Person.class))).thenReturn(savedPerson);
        when(personMapper.toDTO(any(Person.class))).thenReturn(expectedSavedPersonDTO);

        PersonDTO actualSavedPersonDTO = personService.create(personDTO);

        assertEquals(expectedSavedPersonDTO, actualSavedPersonDTO);
    }

    @Test
    void whenGetAll_thenReturnPersonDTOList() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = PersonUtils.createFakeDTO();

        personDTO.setId(person.getId());

        List<Person> listOfPeople = List.of(person);
        List<PersonDTO> expectedListOfPersonDTO = List.of(personDTO);

        when(personMapper.toDTO(any(Person.class))).thenReturn(personDTO);
        when(personRepository.findAll()).thenReturn(listOfPeople);

        List actualListOfPersonDTO = personService.getAll();

        assertEquals(expectedListOfPersonDTO, actualListOfPersonDTO);
    }

    @Test
    void givenPersonId_whenGetById_thenReturnFoundPersonDTO() throws PersonNotFoundException {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO expectedPersonDTO = PersonUtils.createFakeDTO();

        expectedPersonDTO.setId(person.getId());

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(person));
        when(personMapper.toDTO(any(Person.class))).thenReturn(expectedPersonDTO);

        PersonDTO actualPersonDTO = personService.getById(person.getId());

        assertEquals(expectedPersonDTO, actualPersonDTO);
    }

    @Test  // testa indiretamente o m??todo verifyIfExists, cobrindo tamb??m os m??todos update e delete
    void givenPersonId_whenGetById_thenThrowPersonNotFoundException() {
        assertThrows(PersonNotFoundException.class, () -> personService.getById(42L));
    }

    @Test
    void givenPersonId_whenUpdate_thenReturnUpdatedPersonDTO() throws PersonNotFoundException {
        Person person = PersonUtils.createFakeEntity();
        Person updatedPerson = PersonUtils.createFakeEntity();
        PersonDTO updatedPersonDTO = PersonUtils.createFakeDTO();
        Person savedPerson = PersonUtils.createFakeEntity();
        PersonDTO expectedPersonDTO = PersonUtils.createFakeDTO();

        updatedPerson.setId(null);
        expectedPersonDTO.setId(savedPerson.getId());

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(person));
        when(personMapper.toModel(any(PersonDTO.class))).thenReturn(updatedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(savedPerson);
        when(personMapper.toDTO(any(Person.class))).thenReturn(expectedPersonDTO);

        PersonDTO actualPersonDTO = personService.update(person.getId(), updatedPersonDTO);

        assertEquals(expectedPersonDTO, actualPersonDTO);
    }

    @Test
    void givenPersonId_whenDelete_thenReturnDeletedPersonDTO() throws PersonNotFoundException {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO expectedPersonDTO = PersonUtils.createFakeDTO();

        expectedPersonDTO.setId(person.getId());

        when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(person));
        when(personMapper.toDTO(any(Person.class))).thenReturn(expectedPersonDTO);

        PersonDTO actualPersonDTO = personService.delete(person.getId());

        assertEquals(expectedPersonDTO, actualPersonDTO);
    }

}
