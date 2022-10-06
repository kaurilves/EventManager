package org.example.entities;

import lombok.*;
import org.example.config.ServiceConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_types", schema = ServiceConfig.SCHEMA_NAME)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTypeEntity extends IdEntity {

    @Column
    private String name;

}