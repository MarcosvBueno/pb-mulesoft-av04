package br.com.paymentservicepb.services;

import br.com.paymentservicepb.constants.Brand;
import br.com.paymentservicepb.constants.CurrencyType;
import br.com.paymentservicepb.constants.PaymentStatus;
import br.com.paymentservicepb.constants.PaymentType;
import br.com.paymentservicepb.dto.OrderDto;
import br.com.paymentservicepb.form.OrderForm;
import br.com.paymentservicepb.model.Items;
import br.com.paymentservicepb.model.Payment;
import br.com.paymentservicepb.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest(classes = PaymentService.class)
class PaymentServiceTest {

    @Autowired
    private PaymentService service;

    @SpyBean
    private ModelMapper modelMapper;

    @MockBean
    private OrderRepository repository;


    @Test
    void
    shouldCreateANewOrderWithWrongCredentialsAndReturnAStatusOfDeclined() {
        OrderForm orderForm = OrderFormRecused();

        OrderDto orderDto = service.registerNewOrder(orderForm);

        Assertions.assertNotNull(orderDto);
        Assertions.assertNull(orderDto.getOrderId());
        Assertions.assertNotNull(orderDto.getPaymentId());
        Assertions.assertEquals(new BigDecimal(60), orderDto.getTotal());
        Assertions.assertEquals(PaymentStatus.RECUSED, orderDto.getPaymentStatus());
        Assertions.assertEquals("Expired card", orderDto.getMessage());
    }


    @Test
    void shouldCreateANewOrderWithCorrectCredentialsAndReturnAStatusOfApproved(){
        OrderForm orderForm = orderFormAproved();

        OrderDto orderDto = service.registerNewOrder(orderForm);

        Assertions.assertNotNull(orderDto);
        Assertions.assertNull(orderDto.getOrderId());
        Assertions.assertNotNull(orderDto.getPaymentId());
        Assertions.assertEquals(new BigDecimal(60), orderDto.getTotal());
        Assertions.assertEquals(PaymentStatus.APPROVED, orderDto.getPaymentStatus());
        Assertions.assertEquals("Transaction approved", orderDto.getMessage());
    }



    @Test
    void listOrders() {
    }

    @Test
    void orderById() {

    }


    public OrderForm orderFormAproved(){
        List<OrderForm> orderFormList = new ArrayList<>();
        List<Items> items =  new ArrayList<>();
        Items item = new Items("fanta-uva", new BigDecimal(5), 10);
        items.add(item);
        PaymentType paymentType = PaymentType.CREDIT_CARD;
        CurrencyType currencyType = CurrencyType.BRL;
        Payment payment = new Payment("1234345545987681", "JOAO DA SILVA","123",12,2040, Brand.MASTERCARD);

        return new OrderForm("12323321312",items,new BigDecimal(20),new BigDecimal(10),paymentType,currencyType,payment);

    }

    public OrderForm OrderFormRecused(){
        List<OrderForm> orderFormList = new ArrayList<>();
        List<Items> items =  new ArrayList<>();
        Items item = new Items("fanta-uva", new BigDecimal(5), 10);
        items.add(item);
        PaymentType paymentType = PaymentType.CREDIT_CARD;
        CurrencyType currencyType = CurrencyType.BRL;
        Payment payment = new Payment("1234345545987681", "JOAO DA SILVA","123",10,2020, Brand.MASTERCARD);

        return new OrderForm("12323321312",items,new BigDecimal(20),new BigDecimal(10),paymentType,currencyType,payment);

    }

    public OrderDto OrderDtoByOrder(){
        PaymentStatus paymentStatus = PaymentStatus.APPROVED;
        return new OrderDto(
                (long)1,new BigDecimal(60),"1c3a1fec-9c4b-4b86-a2a2-ff537d29d3c7",PaymentStatus.APPROVED,"Transaction approved");
    }

}