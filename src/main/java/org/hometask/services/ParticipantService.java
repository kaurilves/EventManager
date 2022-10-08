package org.hometask.services;

import org.hometask.dtos.participants.Participant;

import org.hometask.dtos.participants.ParticipantCreate;

import org.hometask.dtos.participants.ParticipantUpdate;
import org.hometask.entities.ParticipantEntity;
import org.hometask.mappers.ParticipantMapper;
import org.hometask.repositories.ParticipantRepository;
import org.hometask.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
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


    public Participant addParticipant(ParticipantCreate participantCreate) throws Exception {
        boolean alreadyParticipates = participantRepository.existsByPersonId(
                personService.getPersonByIdNumber(participantCreate.getIdNumber()).getId());
        if (!alreadyParticipates) {
            ParticipantEntity participantEntity = participantMapper
                    .participantCreateToParticipantEntity(participantCreate);
            participantEntity.setPersonId(personService.addPerson(participantCreate).getId());
            participantEntity.setPaymentTypeEntity(paymentTypeRepository
                    .getReferenceById(participantCreate.getPaymentTypeId()));
            participantRepository.save(participantEntity);

            return participantMapper.participantEntityToParticipant(participantEntity);
        } else {

            throw new Exception("Person with a same idNumber already participates this event");
        }
    }

    public List<Participant> findEventParticipants(UUID eventId) {
        List<ParticipantEntity> participantEntities = participantRepository.findParticipantsBy(eventId);

        return participantMapper.participantEntitiesToParticipants(participantEntities);
    }

    public Participant updateParticipant(UUID participantId, ParticipantUpdate participantUpdate) {
        ParticipantEntity participantEntity = participantRepository.findById(participantId).orElseThrow();
        participantEntity.setPersonId(personService.addPerson(
                participantMapper.participantUpdateToParticipantCreate(participantUpdate)).getId());
        participantEntity.setPaymentTypeEntity(
                paymentTypeRepository.getReferenceById(participantUpdate.getPaymentTypeId()));
        participantEntity.setParticipantsCount(participantUpdate.getParticipantsCount());
        participantEntity.setAdditionalInfo(participantUpdate.getAdditionalInfo());
        participantRepository.save(participantEntity);

        return participantMapper.participantEntityToParticipant(participantEntity);
    }

    public void deleteParticipant(UUID participantId) {
        participantRepository.deleteById(participantId);
    }

    public void deleteAllParticipants(UUID eventId) {
        participantRepository.deleteAllByEventId(eventId);
    }

    public Integer countEventParticipants(UUID eventId) {
        Integer participantsCounter = 0;
        List<Participant> participants = findEventParticipants(eventId);
        for (Participant participant : participants) {
            participantsCounter += participant.getParticipantsCount();
        }
        return participantsCounter;
    }
}
