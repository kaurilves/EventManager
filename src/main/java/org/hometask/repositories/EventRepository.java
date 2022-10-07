package org.hometask.repositories;

import org.hometask.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Resource
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
    @Query("select e from EventEntity e where e.eventDate > ?1 order by e.eventDate")
    List<EventEntity> findByEventDateGreaterThan(LocalDateTime eventDate);

    @Query("select e from EventEntity e where e.eventDate < ?1 order by e.eventDate DESC")
    List<EventEntity> findByEventDateLessThan(LocalDateTime eventDate);






}
