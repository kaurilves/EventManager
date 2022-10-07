package org.example.mappers;

import org.example.dtos.Event;
import org.example.dtos.EventCreate;
import org.example.dtos.PaymentType;
import org.example.dtos.PaymentTypeCreate;
import org.example.entities.EventEntity;
import org.example.entities.PaymentTypeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EventMapper {

    EventEntity eventCreateToEventEntity(EventCreate event);

    Event eventEntityToEvent(EventEntity event);
}
