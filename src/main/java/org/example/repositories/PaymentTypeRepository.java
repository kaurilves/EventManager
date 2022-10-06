package org.example.repositories;

import org.example.entities.PaymentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, UUID> {
}
