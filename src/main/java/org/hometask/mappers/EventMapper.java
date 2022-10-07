package org.hometask.mappers;

import org.hometask.dtos.Event;
import org.hometask.dtos.EventCreate;
import org.hometask.entities.EventEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventMapper {

    EventEntity eventCreateToEventEntity(EventCreate event);

    Event eventEntityToEvent(EventEntity event);

    List<Event> eventEntitiesToEvents(List<EventEntity> eventEntities);
}
