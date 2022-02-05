package com.dio.personapi.resource;

import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.dto.request.PhoneDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.service.PersonService;
import com.dio.personapi.type.PhoneType;
import com.dio.personapi.utils.PersonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService personService;

    ObjectMapper objectMapper = new ObjectMapper();

    final String URI = "/api/v1/people";

    @Test
    void givenPersonDTO_whenCreate_thenReturnResponseEntityWithPersonDTO() throws Exception {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        PersonDTO savedPersonDTO = PersonUtils.createFakeDTO();

        savedPersonDTO.setId(1L);

        when(personService.create(any(PersonDTO.class))).thenReturn(savedPersonDTO);

        mockMvc.perform(post(URI)
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(savedPersonDTO))
        );
    }

    @Test
    void whenListAll_thenReturnPersonDTOList() throws Exception {
        PersonDTO personDTO1 = PersonUtils.createFakeDTO();
        PersonDTO personDTO2 = PersonUtils.createFakeDTO();

        personDTO1.setId(1L);
        personDTO1.getPhones().get(0).setId(1L);
        personDTO2.setId(2L);
        personDTO2.getPhones().get(0).setId(2L);
        personDTO2.setFirstName("Joao");
        personDTO2.setLastName("das Neves");
        personDTO2.setCpf("36225282653");
        personDTO2.setBirthDate("10-07-2018");

        var peopleList = List.of(personDTO1, personDTO2);

        when(personService.getAll()).thenReturn(peopleList);

        mockMvc.perform(get(URI)
                .accept(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(peopleList))
        );
    }

    @Test
    void givenPersonId_whengetPersonById_thenReturnFoundPersonDTO() throws Exception {
        PersonDTO personDTO = PersonUtils.createFakeDTO();

        personDTO.setId(1L);
        personDTO.getPhones().get(0).setId(1L);

        when(personService.getById(any(Long.class))).thenReturn(personDTO);

        mockMvc.perform(get(URI.concat("/{id}"), 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(personDTO)));
    }

    @Test
    void givenPersonIdAndPersonDTO_whenUpdate_thenReturnUpdatedPersonDTO() throws Exception {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        PersonDTO updatedPersonDTO = PersonUtils.createFakeDTO();

        updatedPersonDTO.setId(1L);
        updatedPersonDTO.getPhones().get(0).setId(1L);

        when(personService.update(any(Long.class), any(PersonDTO.class))).thenReturn(updatedPersonDTO);

        mockMvc.perform(put(URI.concat("/{id}"), 1L)
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(updatedPersonDTO))
        );
    }

    @Test
    void givenPersonId_whenDelete_thenReturnDeletedPersonDTO() throws Exception {
        PersonDTO deletedPersonDTO = PersonUtils.createFakeDTO();

        deletedPersonDTO.setId(1L);
        deletedPersonDTO.getPhones().get(0).setId(1L);

        when(personService.delete(any(Long.class))).thenReturn(deletedPersonDTO);

        mockMvc.perform(delete(URI.concat("/{id}"), 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(objectMapper.writeValueAsString(deletedPersonDTO))
        );
    }

}
