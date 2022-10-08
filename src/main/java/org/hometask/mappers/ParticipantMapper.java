package org.hometask.mappers;


import org.hometask.dtos.participants.Participant;
import org.hometask.dtos.participants.ParticipantCreate;
import org.hometask.entities.ParticipantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ParticipantMapper {

    ParticipantEntity participantCreateToParticipantEntity (ParticipantCreate participantCreate);

    @Mapping(source = "paymentTypeEntity.id", target = "paymentTypeId")
    Participant participantEntityToParticipant(ParticipantEntity participantEntity);
}
