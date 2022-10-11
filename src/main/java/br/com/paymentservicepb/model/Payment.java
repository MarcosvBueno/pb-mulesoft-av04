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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Size(min = 14, max = 16)
    @Column(name = "card_number")
    @NotNull(message = "card_number must not be null")
    private String cardNumber;

    @NotNull (message = "card_number must not be null")
    @Column(name = "card_holder_name")
    private String cardholdername;

    @NotNull (message = "security_code must not be null")
    @Size(min = 3, max = 3)
    @Column(name = "security_code")
    private String securityCode;


    @NotNull (message = "expiration_month must not be null")
    @Length(min = 2, max = 2)
    private Integer expiration_month;

    @Length(min = 2, max = 2)
    private Integer expiration_year;


    @Enumerated(EnumType.STRING)
    private Brand brand;
}
