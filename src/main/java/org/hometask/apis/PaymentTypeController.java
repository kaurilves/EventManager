package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.payment.PaymentType;
import org.hometask.dtos.payment.PaymentTypeCreate;
import org.hometask.services.PaymentTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Payments")
@RequestMapping("/payments")
public class PaymentTypeController {

    @Resource
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "get payment all types")
    @GetMapping
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes();
    }

    @Operation(summary = "add new payment type")
    @PostMapping
    public PaymentType addNewPaymentType(@Valid @RequestBody PaymentTypeCreate paymentTypeCreate) {
        return paymentTypeService.addNewPaymentType(paymentTypeCreate);
    }
}
