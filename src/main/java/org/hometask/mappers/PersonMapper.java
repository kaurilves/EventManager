package org.hometask.mappers;

import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.dtos.participants.Person;
import org.hometask.dtos.participants.PersonCreate;
import org.hometask.entities.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonMapper {
    PersonEntity participantCreateToPersonEntity(ParticipantCreate participantCreate);

    Person personEntityToPerson(PersonEntity personEntity);
}
