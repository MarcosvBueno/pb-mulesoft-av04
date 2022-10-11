package br.com.paymentservicepb.form;

import br.com.paymentservicepb.constants.CurrencyType;
import br.com.paymentservicepb.constants.PaymentType;
import br.com.paymentservicepb.constants.DocumentType;
import br.com.paymentservicepb.model.Items;
import br.com.paymentservicepb.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {

    private String document_type;

    @Valid
    @NotEmpty(message = "Adicione pelo menos 1 item ao pedido")
    private List<@Valid Items> items;

    @NotNull
    @PositiveOrZero
    private BigDecimal shipping;

    @NotNull
    @PositiveOrZero
    private BigDecimal discount;

    private PaymentType payment_type;

    private CurrencyType currency_type;

    @NotNull
    private Payment payment;
}
