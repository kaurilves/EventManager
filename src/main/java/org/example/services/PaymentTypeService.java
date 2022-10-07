package org.example.services;

import org.example.dtos.PaymentType;
import org.example.dtos.PaymentTypeCreate;
import org.example.entities.PaymentTypeEntity;
import org.example.mappers.PaymentTypeMapper;
import org.example.repositories.PaymentTypeRepository;
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
