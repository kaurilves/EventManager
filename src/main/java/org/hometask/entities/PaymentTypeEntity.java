package org.hometask.entities;

import lombok.*;
import org.hometask.config.ServiceConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_types", schema = ServiceConfig.SCHEMA_NAME)
public class PaymentTypeEntity{

    @Id
    @Column
    private UUID id;
    @Column
    private String name;

}