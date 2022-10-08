package br.com.paymentservicepb.util;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.model.OrderEntity;

public class Mapper {

    public static OrderDto convertOrderEntityToDto(OrderEntity paymentEntity) {
       OrderDto orderDto = new OrderDto(
               paymentEntity.getOrderId(),
                paymentEntity.getTotal(),
                paymentEntity.getPaymentId(),
                paymentEntity.getPaymentStatus(),
                paymentEntity.getMessage());
        return orderDto;
    }
}
