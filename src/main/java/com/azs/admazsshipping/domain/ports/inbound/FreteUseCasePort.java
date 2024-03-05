package com.azs.admazsshipping.domain.ports.inbound;

import com.azs.admazsshipping.domain.domain.Frete;
import com.azs.admazsshipping.domain.domain.Paginacao;

import java.util.List;

public interface FreteUseCasePort {
    Frete cadastrarFrete(Frete frete);
    List<Frete> buscarFretes(Paginacao paginacao, String parametro);
    Frete atualizarFrete(Frete frete);
    void removerFrete(Long id);
}
