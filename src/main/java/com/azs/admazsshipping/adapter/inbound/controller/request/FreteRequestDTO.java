package com.azs.admazsshipping.adapter.inbound.controller.request;

import com.azs.admazsshipping.domain.domain.Frete;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class FreteRequestDTO {

    @NotBlank(message = "{campo-obrigatorio}")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "{expressao-regular-erro}")
    private String cepOrigem;
    @NotBlank(message = "{campo-obrigatorio}")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "{expressao-regular-erro}")
    private String cepDestino;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal altura;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal largura;
    @DecimalMin(value = "0.00", inclusive = false, message = "{valor-decimal-erro}")
    private BigDecimal comprimento;
    private BigDecimal peso;
    private BigDecimal valor;
    private BigDecimal cubagem;

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

    public BigDecimal getCubagem() {
        return cubagem;
    }

    public Frete toFreteDomain(){
        return new Frete(this.cepOrigem,
                         this.cepDestino,
                         this.altura,
                         this.largura,
                         this.comprimento,
                         this.peso,
                         this.valor);
    }

}
