package com.azs.admazsshipping.domain.domain;

import java.math.BigDecimal;

public class Frete {

    private Long id;
    private String cepOrigem;
    private String cepDestino;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal peso;
    private BigDecimal valor;
    private BigDecimal cubagem;

    public Frete() {
    }

    public Frete(String cepOrigem, String cepDestino, BigDecimal altura, BigDecimal largura, BigDecimal comprimento, BigDecimal peso, BigDecimal valor) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.valor = valor;
    }

    public Frete(Long id, String cepOrigem, String cepDestino, BigDecimal altura, BigDecimal largura, BigDecimal comprimento, BigDecimal peso, BigDecimal valor) {
        this.id = id;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.valor = valor;
    }

    public Frete(Long id, String cepOrigem, String cepDestino, BigDecimal altura, BigDecimal largura, BigDecimal comprimento, BigDecimal peso, BigDecimal valor, BigDecimal cubagem) {
        this.id = id;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.valor = valor;
        this.cubagem = cubagem;
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

}
