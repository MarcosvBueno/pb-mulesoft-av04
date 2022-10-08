package br.com.paymentservicepb.dto;

import br.com.paymentservicepb.constants.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;

    private BigDecimal total;

    private String paymentId;

    private PaymentStatus paymentStatus;

    private String message;
}
