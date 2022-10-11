package br.com.paymentservicepb.controller;

import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.model.OrderEntity;
import br.com.paymentservicepb.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<OrderDto> ListAllOrders(@PageableDefault(size = 10) Pageable pagination) {
        return service.ListOrders(pagination);

    }
/*
    @GetMapping
    public List<OrderApprovedDto> getAll(){
        List<OrderTransaction> order=paymentService.getAll();
        return OrderApprovedDto.convert(order);
    }

 */
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> orderById (@PathVariable @NotNull Long id) {
        try {
            return service.orderById(id);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}