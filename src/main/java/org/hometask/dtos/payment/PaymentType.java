package org.hometask.dtos.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class PaymentType implements Serializable {
    private  UUID id;
    private  String name;
}