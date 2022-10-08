package br.com.paymentservicepb.services;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.model.OrderEntity;
import br.com.paymentservicepb.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository repository;


    public OrderDto registerNewOrder(OrderForm form) {
        OrderEntity order = modelMapper.map(form, OrderEntity.class);
        order.result();
        repository.save(order);
         return modelMapper.map(order, OrderDto.class);
    }
}
