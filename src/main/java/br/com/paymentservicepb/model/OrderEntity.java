package br.com.paymentservicepb.model;

import br.com.paymentservicepb.constants.CurrencyType;
import br.com.paymentservicepb.constants.PaymentStatus;
import br.com.paymentservicepb.constants.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id",nullable = false)
    private Long orderId;

    private String cpf;
    @Transient
    @OneToMany(targetEntity= OrderEntity.class, fetch=FetchType.EAGER)
    private List<Items> items ;

    private BigDecimal shipping;

    private BigDecimal discount;


    @Enumerated(EnumType.STRING)
    private PaymentType payment_type;


    @Enumerated(EnumType.STRING)
    private CurrencyType currency_type;

    @Transient
    private Payment payment;


    public OrderEntity(String cpf, List<Items> items, BigDecimal shipping, BigDecimal discount, PaymentType payment_type, CurrencyType currency_type, Payment payment) {
        this.cpf = cpf;
        this.items = items;
        this.shipping = shipping;
        this.discount = discount;
        this.payment_type = payment_type;
        this.currency_type = currency_type;
        this.payment = payment;
    }

    private BigDecimal total = new BigDecimal(0);

    @Column(name = "payment_id", nullable = false)
    private String paymentId = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.APPROVED;

    private String message = "transaction approved";

    private  BigDecimal calculateTotal(){
        items.forEach(i -> setTotal(getTotal().add(new BigDecimal(i.getQty()).multiply(i.getValue()))));
        setTotal(getTotal().add(getShipping()));
        return getTotal().subtract(getDiscount());
    }

    public void result(){
        this.total = calculateTotal();
    }
}

