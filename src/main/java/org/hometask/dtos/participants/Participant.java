package org.hometask.dtos.participants;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data

public class Participant implements Serializable {

    @NotNull
    private UUID eventId;

    @NotNull
    private UUID personId;

    @NotNull
    private UUID paymentTypeId;

    @NotNull
    @Size(min = 1)
    private Integer participantsCount;

    private  String additionalInfo;
}
