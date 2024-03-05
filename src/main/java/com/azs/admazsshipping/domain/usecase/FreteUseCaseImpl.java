package com.azs.admazsshipping.domain.usecase;

import com.azs.admazsshipping.domain.domain.Frete;
import com.azs.admazsshipping.domain.domain.Paginacao;
import com.azs.admazsshipping.domain.ports.inbound.FreteUseCasePort;
import com.azs.admazsshipping.domain.ports.outbound.FreteAdapterPort;

import java.util.List;

public class FreteUseCaseImpl implements FreteUseCasePort {

    private final FreteAdapterPort freteAdapterPort;

    public FreteUseCaseImpl(FreteAdapterPort freteAdapterPort) {
        this.freteAdapterPort = freteAdapterPort;
    }

    @Override
    public Frete cadastrarFrete(Frete frete) {
        return freteAdapterPort.cadastrarFrete(frete);
    }

    @Override
    public List<Frete> buscarFretes(Paginacao paginacao, String parametro) {
        return freteAdapterPort.buscarFretes(paginacao, parametro);
    }

    @Override
    public Frete atualizarFrete(Frete frete) {
        return freteAdapterPort.atualizarFrete(frete);
    }

    @Override
    public void removerFrete(Long id) {
        freteAdapterPort.removerFrete(id);
    }
}
