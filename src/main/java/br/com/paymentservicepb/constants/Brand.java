package br.com.paymentservicepb.constants;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum Brand {
    MASTERCARD,
    VISA,
    ELO,
    AMERICAN_EXPRESS;

    private String name;
}
