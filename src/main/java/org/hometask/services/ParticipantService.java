package org.hometask.services;

import org.hometask.dtos.participants.Participant;

import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.PersonCreate;
import org.hometask.entities.ParticipantEntity;
import org.hometask.mappers.ParticipantMapper;
import org.hometask.repositories.ParticipantRepository;
import org.hometask.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class ParticipantService {

    @Resource
    private ParticipantRepository participantRepository;

    @Resource
    private ParticipantMapper participantMapper;

    @Resource
    private PersonService personService;

    @Resource
    private PaymentTypeRepository paymentTypeRepository;


    public Participant addParticipant(PersonCreate personCreate, ParticipantCreate participantCreate) {
        ParticipantEntity participantEntity = participantMapper.participantCreateToParticipantEntity(participantCreate);
        participantEntity.setPersonId(personService.addPerson(personCreate).getId());
        participantEntity.setPaymentTypeEntity(paymentTypeRepository.getReferenceById(participantCreate.getPaymentTypeId()));
        participantRepository.save(participantEntity);
        return participantMapper.participantEntityToParticipant(participantEntity);
    }
}
