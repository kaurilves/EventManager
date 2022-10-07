package org.hometask.entities;

import lombok.*;
import org.hometask.config.ServiceConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_types", schema = ServiceConfig.SCHEMA_NAME)
public class PaymentTypeEntity extends IdEntity {

    @Column
    private String name;

}