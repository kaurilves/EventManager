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
    private EventMapper eventMapper;

    @Resource
    private ParticipantService participantService;

    public Event createEvent(EventCreate eventCreate) {
        EventEntity event = eventRepository.save(eventMapper.eventCreateToEventEntity(eventCreate));
        return eventMapper.eventEntityToEvent(event);
    }

    public Event getEvent(UUID eventId) {
        EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow();
        return eventMapper.eventEntityToEvent(eventEntity);
    }

    public List<Event> findAllFutureEvents() {
        List<EventEntity> eventEntities = eventRepository.findByEventDateGreaterThan(LocalDateTime.now());
        return eventMapper.eventEntitiesToEvents(eventEntities);
    }

    public List<Event> findAllPastEvents() {
        List<EventEntity> eventEntities = eventRepository.findByEventDateLessThan(LocalDateTime.now());
        return eventMapper.eventEntitiesToEvents(eventEntities);
    }

    public Event updateEvent(UUID eventId, EventUpdate eventUpdate) throws Exception {
        EventEntity eventEntity = eventRepository.findById(eventId).orElseThrow();
        if (eventEntity.getEventDate().isBefore(LocalDateTime.now())) {
            throw new Exception("Can´t update past events");
        }
        eventEntity.setName(eventUpdate.getName());
        eventEntity.setAddress(eventUpdate.getAddress());
        eventEntity.setEventDate(eventUpdate.getEventDate());
        eventEntity.setAdditionalInfo(eventUpdate.getAdditionalInfo());
        eventRepository.save(eventEntity);
        return eventMapper.eventEntityToEvent(eventEntity);
    }
    public void deleteEvent(UUID eventId) throws Exception {
        if (eventRepository.findById(eventId).orElseThrow().getEventDate().isBefore(LocalDateTime.now())) {
            throw new Exception("Can´t delete past events");
        }
        participantService.deleteAllParticipants(eventId);
        eventRepository.delete(eventRepository.findById(eventId).get());

    }


}
