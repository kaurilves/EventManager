package org.hometask.dtos.participants;

import lombok.Data;
import org.hometask.models.PersonType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

@Data
public class ParticipantCreate implements Serializable {

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    private BigInteger idNumber;


    @NotNull
    private PersonType personType;

    @NotNull
    private UUID eventId;

    @NotNull
    private UUID paymentTypeId;

    @NotNull
    private Integer participantsCount;

    private String additionalInfo;

}
