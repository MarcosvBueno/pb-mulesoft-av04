package br.com.paymentservicepb.services;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.model.OrderEntity;
import br.com.paymentservicepb.repository.OrderRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Getter
public class PaymentService {
    @Autowired
    private ModelMapper modelMapper;

    public PaymentService(OrderRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private OrderRepository repository;



    public OrderDto registerNewOrder(OrderForm form) {
        OrderEntity order = modelMapper.map(form, OrderEntity.class);
        order.result();
        repository.save(order);
        return modelMapper.map(order, OrderDto.class);
    }

    public List<OrderDto> ListOrders(){
        List<OrderEntity> orders = repository.findAll();
        return orders.stream().map(o -> modelMapper.map(o , OrderDto.class)).collect(Collectors.toList());
    }


        public OrderDto orderById (Long id) {

            return modelMapper.map(repository.findById(id), OrderDto.class);
        }

}




