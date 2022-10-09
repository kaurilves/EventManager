package org.hometask.entities;

import lombok.*;

import org.hometask.config.ServiceConfig;
import org.hometask.models.PersonType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigInteger;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participants", schema = ServiceConfig.SCHEMA_NAME)
public class ParticipantEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID id;

    @Column
    private String name;

    @Column
    private BigInteger idNumber;

    @Column
    private PersonType personType;

    @Column
    private UUID eventId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_type")
    private PaymentTypeEntity paymentTypeEntity;

    @Column
    private Integer participantsCount;

    @Column
    private String additionalInfo;

}
