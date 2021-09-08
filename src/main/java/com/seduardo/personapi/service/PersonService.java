package com.seduardo.personapi.service;

import com.seduardo.personapi.Repository.PersonRepository;
import com.seduardo.personapi.dto.request.PersonDTO;
import com.seduardo.personapi.dto.response.MessageResponseDTO;
import com.seduardo.personapi.entity.Person;
import com.seduardo.personapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savedPerson.getId())
                .build();
    }
}
