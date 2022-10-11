package br.com.paymentservicepb.util;

import br.com.paymentservicepb.constants.PaymentStatus;
import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.model.OrderEntity;

public class Mapper {

    private Long orderId;

    private double total;

    private String paymentId;

    private PaymentStatus paymentStatus;

    private String message;

    public static OrderDto convertOrderEntityToDto(OrderEntity order) {
       OrderDto orderDto = new OrderDto(
               order.getOrderId(),
                order.getTotal(),
                order.getPaymentId(),
                order.getPaymentStatus(),
                order.getMessage());

       return orderDto;
    }

}
