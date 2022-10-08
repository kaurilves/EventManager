package org.hometask.dtos.participants;

import lombok.Data;
import org.hometask.models.PersonType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

@Data
public class Person implements Serializable {

    private UUID id;
    private String name;
    private BigInteger idNumber;
    private PersonType personType;

}
