package org.hometask.repositories;

import org.hometask.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.UUID;

@Resource
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    boolean existsByIdNumber(BigInteger idNumber);

    PersonEntity findByIdNumber(BigInteger idNumber);


}
