package org.hometask.services;

import org.hometask.dtos.event.Event;
import org.hometask.dtos.event.EventCreate;
import org.hometask.dtos.event.EventUpdate;
import org.hometask.entities.EventEntity;
import org.hometask.mappers.EventMapper;
import org.hometask.repositories.EventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;
    @Resource
    private ParticipantService participantService;

    @Resource
    private EventMapper eventMapper;

    public Event createEvent (EventCreate eventCreate){
        EventEntity event = eventRepository.save(eventMapper.eventCreateToEventEntity(eventCreate));
        return eventMapper.eventEntityToEvent(event);
    }

    public Event getEvent (UUID eventId){
        EventEntity eventEntity = eventRepository.findById(eventId).get();
       return eventMapper.eventEntityToEvent(eventEntity);
    }

    public List<Event> findAllFutureEvents(){
        List<EventEntity> eventEntities = eventRepository.findByEventDateGreaterThan(LocalDateTime.now());
        return eventMapper.eventEntitiesToEvents(eventEntities);
    }
    public Boolean eventInFutureCheck(UUID eventId){
        return eventRepository.findById(eventId).orElseThrow().getEventDate().isAfter(LocalDateTime.now());
    }
    public List<Event> findAllPastEvents(){
        List<EventEntity> eventEntities = eventRepository.findByEventDateLessThan(LocalDateTime.now());
        return eventMapper.eventEntitiesToEvents(eventEntities);
    }

    public Event updateEvent(UUID eventId, EventUpdate eventUpdate) {
        EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow();
        if (eventInFutureCheck(eventId)) {
            eventEntity.setName(eventUpdate.getName());
            eventEntity.setAddress(eventUpdate.getAddress());
            eventEntity.setEventDate(eventUpdate.getEventDate());
            eventEntity.setAdditionalInfo(eventUpdate.getAdditionalInfo());
            eventRepository.save(eventEntity);
            return eventMapper.eventEntityToEvent(eventEntity);
        } else {
            return null;
        }
    }
    public void deleteEvent (UUID eventId){
        participantService.deleteAllParticipants(eventId);
        eventRepository.delete(eventRepository.findById(eventId).get());
    }



}
