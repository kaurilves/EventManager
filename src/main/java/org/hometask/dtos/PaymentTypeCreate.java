package org.hometask.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Getter
public class PaymentTypeCreate implements Serializable {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String name;
}