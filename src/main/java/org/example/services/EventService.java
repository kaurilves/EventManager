package org.example.services;

import org.example.dtos.Event;
import org.example.dtos.EventCreate;
import org.example.entities.EventEntity;
import org.example.mappers.EventMapper;
import org.example.repositories.EventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


}
