package br.com.paymentservicepb.form;

import br.com.paymentservicepb.constants.CurrencyType;
import br.com.paymentservicepb.constants.PaymentType;
import br.com.paymentservicepb.model.Items;
import br.com.paymentservicepb.model.Payment;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderForm {

    private String cpf;

    private List<Items> items;

    private BigDecimal shipping;

    private BigDecimal discount;

    private PaymentType payment_type;

    private CurrencyType currency_type;

    private Payment payment;
}
