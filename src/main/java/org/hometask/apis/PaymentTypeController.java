package org.hometask.apis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hometask.dtos.PaymentType;
import org.hometask.dtos.PaymentTypeCreate;
import org.hometask.services.PaymentTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Payment Types")
@RequestMapping("/payment-types")
public class PaymentTypeController {

    @Resource
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "get payment types")
    @GetMapping
    public List<PaymentType> getPaymentTypes() {
        return paymentTypeService.getPaymentTypes();
    }

    @Operation(summary = "add new payment type")
    @PostMapping
    public PaymentType addNewPaymentType(@Valid @RequestBody PaymentTypeCreate paymentTypeCreate) {
        return paymentTypeService.addNewPaymentType(paymentTypeCreate);
    }
}
