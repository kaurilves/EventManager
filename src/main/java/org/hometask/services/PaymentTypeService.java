package org.hometask.services;

import org.hometask.dtos.payment.PaymentType;
import org.hometask.dtos.payment.PaymentTypeCreate;
import org.hometask.entities.PaymentTypeEntity;
import org.hometask.mappers.PaymentTypeMapper;
import org.hometask.repositories.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentTypeService {

    @Resource
    private PaymentTypeRepository paymentTypeRepository;

    @Resource
    private PaymentTypeMapper paymentTypeMapper;

    public List<PaymentType> getPaymentTypes(){
        return paymentTypeMapper.paymentTypeEntitiesToPaymentTypes(paymentTypeRepository.findAll());
    }

    public PaymentType addNewPaymentType(PaymentTypeCreate paymentTypeCreate) {
        PaymentTypeEntity entity = paymentTypeMapper.paymentTypeCreateToPaymentTypeEntity(paymentTypeCreate);
        return paymentTypeMapper.paymentTypeEntityToPaymentType(paymentTypeRepository.save(entity));
    }
}
