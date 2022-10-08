package org.hometask.entities;

import lombok.*;

import org.hometask.config.ServiceConfig;

import javax.persistence.*;

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
    private UUID eventId;

    @Column
    private UUID personId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_type")
    private PaymentTypeEntity paymentTypeEntity;

    @Column
    private Integer participantsCount;

    @Column
    private String additionalInfo;

}
