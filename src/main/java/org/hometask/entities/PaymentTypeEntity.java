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
@Table(name = "payment_types", schema = ServiceConfig.SCHEMA_NAME)
public class PaymentTypeEntity {

    @Id
    @GeneratedValue
    @Column
    private UUID id;
    @Column
    private String name;

}