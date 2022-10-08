package org.hometask.dtos.participants;

import lombok.Data;
import org.hometask.models.PersonType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class PersonUpdate implements Serializable {

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(min = 11, max = 11)
    private BigInteger idNumber;

    @NotNull
    private PersonType personType;

}
