package org.hometask.services;

import org.hometask.dtos.Event;
import org.hometask.dtos.EventCreate;
import org.hometask.dtos.EventUpdate;
import org.hometask.entities.EventEntity;
import org.hometask.mappers.EventMapper;
import org.hometask.repositories.EventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EventService {

    @Resource
    private EventRepository eventRepository;

    @Resource
    private EventMapper eventMapper;

    public Event createEvent (EventCreate eventCreate){
        EventEntity event = eventRepository.save(eventMapper.eventCreateToEventEntity(eventCreate));
        return eventMapper.eventEntityToEvent(event);
    }


    // TODO: vaja kontrollida, kas future kontroll on õige.
    public Event updateEvent(UUID eventId, EventUpdate eventUpdate) {
        EventEntity eventEntity = eventRepository.findById(eventId).get();
        if (eventUpdate.getEventDate().isAfter(LocalDateTime.now())) {
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
}
