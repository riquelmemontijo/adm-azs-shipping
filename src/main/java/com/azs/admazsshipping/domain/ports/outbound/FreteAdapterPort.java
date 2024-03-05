package com.azs.admazsshipping.domain.ports.outbound;

import com.azs.admazsshipping.domain.domain.Frete;
import com.azs.admazsshipping.domain.domain.Paginacao;

import java.util.List;

public interface FreteAdapterPort {
    Frete cadastrarFrete(Frete frete);
    List<Frete> buscarFretes(Paginacao paginacao, String parametro);
    Frete atualizarFrete(Frete frete);
    void removerFrete(Long id);
}
