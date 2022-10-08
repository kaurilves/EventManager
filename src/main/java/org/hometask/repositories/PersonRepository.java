package org.hometask.repositories;

import org.hometask.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;
import java.util.UUID;

@Resource
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

}
