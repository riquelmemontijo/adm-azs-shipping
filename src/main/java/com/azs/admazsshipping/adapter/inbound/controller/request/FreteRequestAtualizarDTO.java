package com.azs.admazsshipping.adapter.inbound.controller.request;

import com.azs.admazsshipping.domain.domain.Frete;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class FreteRequestAtualizarDTO {

    @NotNull(message = "{campo-obrigatorio}")
    private Long id;
    @NotBlank(message = "{campo-obrigatorio}")
    private String cepOrigem;
    @NotBlank(message = "{campo-obrigatorio}")
    private String cepDestino;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal altura;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal largura;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal comprimento;
    private BigDecimal peso;
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public BigDecimal getLargura() {
        return largura;
    }

    public BigDecimal getComprimento() {
        return comprimento;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public BigDecimal getValor() {
        return valor;
    }


    public Frete toFreteDomain(){
        return new Frete(this.id,
                         this.cepOrigem,
                         this.cepDestino,
                         this.altura,
                         this.largura,
                         this.comprimento,
                         this.peso,
                         this.valor);
    }

}
