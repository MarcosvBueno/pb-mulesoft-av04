package br.com.paymentservicepb.model;

import br.com.paymentservicepb.constants.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Length(min = 14, max = 16)
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_holder_name")
    private String cardholdername;

    @Length(min = 3, max = 3)
    @Column(name = "security_code")
    private String securityCode;

    private Integer expiration_month;

    private Integer expiration_year;

    @Enumerated(EnumType.STRING)
    private Brand brand;
}
