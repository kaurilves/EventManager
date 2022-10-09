package org.hometask.repositories;


import org.hometask.entities.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantEntity, UUID> {

    List<ParticipantEntity> findByEventId(UUID eventId);

    void deleteAllByEventId(UUID eventId);

    boolean existsByIdNumberAndEventId(BigInteger idNumber, UUID eventId);


}
