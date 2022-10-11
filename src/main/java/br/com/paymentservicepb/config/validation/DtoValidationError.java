package br.com.paymentservicepb.config.validation;

import lombok.Getter;

@Getter
public class DtoValidationError {
    private String campo;
    private String erro;


    public DtoValidationError(String campo, String erro) {
        super();
        this.campo = campo;
        this.erro = erro;
    }


    public String getCampo() {
        return campo;
    }


    public String getErro() {
        return erro;
    }


}



