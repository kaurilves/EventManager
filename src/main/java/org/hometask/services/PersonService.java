package org.hometask.services;


import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.ParticipantUpdate;
import org.hometask.dtos.participants.Person;

import org.hometask.entities.PersonEntity;
import org.hometask.mappers.PersonMapper;
import org.hometask.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.UUID;

@Service
public class PersonService {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private PersonMapper personMapper;


    public Person addPerson(ParticipantCreate participantCreate) {
        PersonEntity personEntity = personRepository.save(personMapper.participantCreateToPersonEntity(participantCreate));
        return personMapper.personEntityToPerson(personEntity);
    }

    public Person getPerson(UUID personId) {
        return personMapper.personEntityToPerson(personRepository.findById(personId).orElseThrow());
    }

    public Person updatePerson(UUID personId, ParticipantUpdate participantUpdate) {
        PersonEntity personEntity = personRepository.findById(personId).orElseThrow();
        personEntity.setName(participantUpdate.getName());
        personEntity.setIdNumber(participantUpdate.getIdNumber());
        personRepository.save(personEntity);
        return personMapper.personEntityToPerson(personEntity);
    }

    public void deletePerson(UUID personId){
        personRepository.deleteById(personId);
    }

    public Boolean personExistsByIdNumber (BigInteger idNumber){
        return personRepository.existsByIdNumber(idNumber);
    }

    public Person getPersonByIdNumber(BigInteger idNumber) {
        return personMapper.personEntityToPerson(personRepository.findByIdNumber(idNumber));

    }

}
