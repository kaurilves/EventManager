package org.hometask.mappers;

import org.hometask.dtos.PaymentType;
import org.hometask.dtos.PaymentTypeCreate;
import org.hometask.entities.PaymentTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PaymentTypeMapper {

    PaymentType paymentTypeEntityToPaymentType(PaymentTypeEntity paymentTypeEntity);

    List<PaymentType> paymentTypeEntitiesToPaymentTypes(List<PaymentTypeEntity> paymentTypeEntities);

    PaymentTypeEntity paymentTypeCreateToPaymentTypeEntity(PaymentTypeCreate paymentTypeCreate);
}
