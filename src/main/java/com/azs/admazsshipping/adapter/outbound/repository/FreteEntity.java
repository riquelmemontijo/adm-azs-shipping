package com.azs.admazsshipping.adapter.outbound.repository;

import com.azs.admazsshipping.domain.domain.Frete;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity(name = "FreteEntity")
@Table(name = "frete")
public class FreteEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cepOrigem;
    private String cepDestino;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal peso;
    private BigDecimal valor;
    private BigDecimal cubagem;

    public FreteEntity() {
    }

    public FreteEntity(Long id, String cepOrigem, String cepDestino, BigDecimal altura, BigDecimal largura, BigDecimal comprimento, BigDecimal peso, BigDecimal valor, BigDecimal cubagem) {
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

    public static FreteEntity fromFreteDomain(Frete frete){

        BigDecimal cubagem = (frete.getAltura().multiply(frete.getLargura()).multiply(frete.getComprimento())).divide(frete.getPeso(), RoundingMode.HALF_UP);

        return new FreteEntity(frete.getId(),
                frete.getCepOrigem(),
                frete.getCepDestino(),
                frete.getAltura(),
                frete.getLargura(),
                frete.getComprimento(),
                frete.getPeso(),
                frete.getValor(),
                cubagem);
    }

    public Frete toFreteDomain(){
        return new Frete(id, cepOrigem, cepDestino, altura, largura, comprimento, peso, valor, cubagem);
    }

}
