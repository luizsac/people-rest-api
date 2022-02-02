package com.dio.personapi.service;

import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.repository.PersonRepository;
import com.dio.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

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

        when(personMapper.toModel(personDTO)).thenReturn(person);
        when(personRepository.save(person)).thenReturn(savedPerson);
        when(personMapper.toDTO(savedPerson)).thenReturn(expectedSavedPersonDTO);

        PersonDTO actualSavedPersonDTO = personService.create(personDTO);

        assertEquals(expectedSavedPersonDTO, actualSavedPersonDTO);

    }

}
