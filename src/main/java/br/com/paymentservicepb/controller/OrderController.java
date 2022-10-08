package br.com.paymentservicepb.controller;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/order/payment")
public class OrderController {

    @Autowired
    private PaymentService service;


    @PostMapping
    public ResponseEntity<OrderDto> registerNewOrder(@RequestBody @Valid OrderForm form, UriComponentsBuilder uriBuilder){
        try {
            OrderDto order = service.registerNewOrder(form);
            URI uri = uriBuilder.path("/api/v1/order/payment/{id}").buildAndExpand(order.getOrderId()).toUri();
            return ResponseEntity.created(uri).body(order);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders(){
        return  service.ListOrders();
    }



    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> orderById(@PathVariable @NotNull Long id) {
        return service.orderById(id);
    }

}