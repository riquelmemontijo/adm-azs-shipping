package com.azs.admazsshipping.adapter.inbound.controller.response;

import com.azs.admazsshipping.domain.domain.Frete;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FreteResponseDTO {

    private Long id;
    private String cepOrigem;
    private String cepDestino;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal peso;
    private BigDecimal valor;
    private BigDecimal cubagem;

    public FreteResponseDTO() {
    }

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

    public BigDecimal getCubagem() {
        return cubagem;
    }

    public FreteResponseDTO(Long id, String cepOrigem, String cepDestino, BigDecimal altura, BigDecimal largura, BigDecimal comprimento, BigDecimal peso, BigDecimal valor, BigDecimal cubagem) {
        this.id = id;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.altura = altura.setScale(2, RoundingMode.UP);
        this.largura = largura.setScale(2, RoundingMode.UP);
        this.comprimento = comprimento.setScale(2, RoundingMode.UP);
        this.peso = peso.setScale(2, RoundingMode.UP);
        this.valor = valor.setScale(2, RoundingMode.UP);
        this.cubagem = cubagem.setScale(4, RoundingMode.UP);
    }

    public static FreteResponseDTO fromFreteDomain(Frete frete){
        return new FreteResponseDTO(frete.getId(),
                                    frete.getCepOrigem(),
                                    frete.getCepDestino(),
                                    frete.getAltura(),
                                    frete.getLargura(),
                                    frete.getComprimento(),
                                    frete.getPeso(),
                                    frete.getValor(),
                                    frete.getCubagem());
    }

}
