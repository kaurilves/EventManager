package org.example.mappers;

import org.example.dtos.PaymentType;
import org.example.dtos.PaymentTypeCreate;
import org.example.entities.PaymentTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PaymentTypeMapper {

    PaymentType paymentTypeEntityToPaymentType(PaymentTypeEntity paymentTypeEntity);

    List<PaymentType> paymentTypeEntitiesToPaymentTypes(List<PaymentTypeEntity> paymentTypeEntities);

    PaymentTypeEntity paymentTypeCreateToPaymentTypeEntity(PaymentTypeCreate paymentTypeCreate);
}
