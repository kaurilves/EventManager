package org.hometask.entities;

import lombok.*;
import org.hometask.config.ServiceConfig;
import org.hometask.models.PersonType;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons", schema = ServiceConfig.SCHEMA_NAME)
public class PersonEntity{

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

}
