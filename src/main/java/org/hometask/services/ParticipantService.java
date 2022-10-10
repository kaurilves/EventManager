package org.hometask.services;

import org.hometask.dtos.event.Event;
import org.hometask.dtos.participants.Participant;

import org.hometask.dtos.participants.ParticipantCreate;

import org.hometask.dtos.participants.ParticipantUpdate;

import org.hometask.entities.ParticipantEntity;
import org.hometask.mappers.ParticipantMapper;
import org.hometask.repositories.ParticipantRepository;
import org.hometask.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Resource
    private ParticipantRepository participantRepository;

    @Resource
    private ParticipantMapper participantMapper;

    @Resource
    private PaymentTypeRepository paymentTypeRepository;


    public Participant addParticipant(Event event, ParticipantCreate participantCreate) throws Exception {
        if (event.getEventDate().isBefore(LocalDateTime.now())) {
            throw new Exception("Can´t add participants to past event");
        } else {
            if (participantRepository.existsByIdNumberAndEventId(participantCreate.getIdNumber(), event.getEventId())) {
                throw new Exception("Person already participates this event");
            } else {
                ParticipantEntity participantEntity = participantMapper.participantCreateToParticipantEntity(participantCreate);
                participantEntity.setPaymentTypeEntity(paymentTypeRepository.getReferenceById(participantCreate.getPaymentTypeId()));
                participantEntity.setEventId(event.getEventId());
                participantRepository.save(participantEntity);
                return participantMapper.participantEntityToParticipant(participantEntity);
            }
        }
    }

    public Participant updateParticipant(Event event, UUID participantId, ParticipantUpdate participantUpdate) throws Exception {
        if (event.getEventDate().isBefore(LocalDateTime.now())) {
            throw new Exception("Can´t update participants of past event");
        } else {

            //       if (participantId !=
            //              participantRepository.findByEventIdAndIdNumber(event.getId(), participantUpdate.getIdNumber()).getId()) {
            //           throw new Exception("Person with that idNumber already participates this event");
            //       } else {
            ParticipantEntity participantEntity = participantRepository.findById(participantId).orElseThrow();
            participantEntity.setName(participantUpdate.getName());
            participantEntity.setIdNumber(participantUpdate.getIdNumber());
            participantEntity.setPaymentTypeEntity(paymentTypeRepository.getReferenceById(participantUpdate.getPaymentTypeId()));
            participantEntity.setPersonType(participantUpdate.getPersonType());
            participantEntity.setParticipantsCount(participantUpdate.getParticipantsCount());
            participantEntity.setAdditionalInfo(participantUpdate.getAdditionalInfo());
            participantRepository.save(participantEntity);
            return participantMapper.participantEntityToParticipant(participantEntity);
        }
    }

    public List<Participant> findEventParticipants(UUID eventId) {
        List<ParticipantEntity> participantEntities = participantRepository.findByEventId(eventId);
        return participantMapper.participantEntitiesToParticipants(participantEntities);
    }

    public void deleteParticipant(UUID participantId) {
        participantRepository.deleteById(participantId);
    }

    public void deleteAllParticipants(UUID eventId) {
        participantRepository.deleteAllByEventId(eventId);
    }


    public Integer sumEventParticipants(UUID eventId) {
        Integer participantsCounter = 0;
        List<Participant> participants = findEventParticipants(eventId);
        for (Participant participant : participants) {
            participantsCounter += participant.getParticipantsCount();
        }
        return participantsCounter;
    }
}
