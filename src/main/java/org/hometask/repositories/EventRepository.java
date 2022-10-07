package org.hometask.repositories;

import org.hometask.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import java.util.UUID;

@Resource
public interface EventRepository extends JpaRepository<EventEntity, UUID> {
}
