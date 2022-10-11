package br.com.paymentservicepb.services;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.model.OrderEntity;
import br.com.paymentservicepb.model.Payment;
import br.com.paymentservicepb.repository.OrderRepository;
import br.com.paymentservicepb.util.Mapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.aspectj.bridge.IMessageHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
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

    public Page<OrderDto> ListOrders(Pageable paginacao){
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, OrderDto.class));
}


        public ResponseEntity<OrderDto> orderById (Long id){
            Optional<OrderEntity> order = repository.findById(id);
            if (order.isPresent()) {
                OrderDto orderDto = Mapper.convertOrderEntityToDto(order.get());
                return ResponseEntity.ok(orderDto);
            }
            return ResponseEntity.notFound().build();
     }


}




