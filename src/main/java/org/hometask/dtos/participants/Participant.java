package org.hometask.dtos.participants;

import lombok.Data;
import org.hometask.models.PersonType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

@Data
public class Participant implements Serializable {

    private UUID id;
    private String name;
    private BigInteger idNumber;
    private PersonType personType;
    private UUID eventId;
    private UUID paymentTypeId;
    private Integer participantsCount;
    private String additionalInfo;
}
