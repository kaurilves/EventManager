package org.hometask.entities;

import lombok.*;
import org.hometask.config.ServiceConfig;
import org.hometask.models.PersonType;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons", schema = ServiceConfig.SCHEMA_NAME)
public class PersonEntity extends IdEntity {


    @Column
    private String name;

    @Column
    private BigInteger idNumber;

    @Column
    private PersonType personType;

}
