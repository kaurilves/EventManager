package org.hometask.repositories;

import org.hometask.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    boolean existsByIdNumber(BigInteger idNumber);

    PersonEntity findByIdNumber(BigInteger idNumber);


}
