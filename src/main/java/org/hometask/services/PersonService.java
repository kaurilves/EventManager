package org.hometask.services;

import org.hometask.dtos.event.EventUpdate;
import org.hometask.dtos.participants.Person;
import org.hometask.dtos.participants.PersonCreate;
import org.hometask.dtos.participants.PersonUpdate;
import org.hometask.entities.PersonEntity;
import org.hometask.mappers.PersonMapper;
import org.hometask.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class PersonService {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private PersonMapper personMapper;


public Person addPerson(PersonCreate personCreate){
    PersonEntity personEntity = personRepository.save(personMapper.personCreateToPersonEntity(personCreate));
    return personMapper.personEntityToPerson(personEntity);
}

public Person getPerson (UUID personId){
    PersonEntity personEntity = personRepository.findById(personId).get();
    return personMapper.personEntityToPerson(personEntity);
}

public Person updatePerson (UUID personId, PersonUpdate personUpdate){
    PersonEntity personEntity = personRepository.findById(personId).get();
    personEntity.setName(personUpdate.getName());
    personEntity.setIdNumber(personUpdate.getIdNumber());
    personRepository.save(personEntity);
    return personMapper.personEntityToPerson(personEntity);
}

}
