package com.azs.admazsshipping.adapter;

import com.azs.admazsshipping.adapter.inbound.exception.RegistroNaoEncontradoException;
import com.azs.admazsshipping.adapter.outbound.repository.FreteEntity;
import com.azs.admazsshipping.adapter.outbound.repository.FreteRepository;
import com.azs.admazsshipping.domain.domain.Frete;
import com.azs.admazsshipping.domain.domain.Paginacao;
import com.azs.admazsshipping.domain.ports.outbound.FreteAdapterPort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteAdapterImpl implements FreteAdapterPort {

    private final FreteRepository freteRepository;

    public FreteAdapterImpl(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Override
    public Frete cadastrarFrete(Frete frete) {
        FreteEntity freteEntity = freteRepository.save(FreteEntity.fromFreteDomain(frete));
        return freteEntity.toFreteDomain();
    }

    @Override
    public List<Frete> buscarFretes(Paginacao paginacao, String parametro) {
        Pageable pageable = PageRequest.of(paginacao.pagina(), paginacao.tamanho());
        List<FreteEntity> freteEntityList = freteRepository.buscarFretes(pageable, parametro).getContent();
        return freteEntityList.stream().map(FreteEntity::toFreteDomain).toList();
    }

    @Override
    public Frete atualizarFrete(Frete frete) {
        freteRepository.findById(frete.getId()).orElseThrow(() -> new RegistroNaoEncontradoException(frete.getId()));
        return freteRepository.save(FreteEntity.fromFreteDomain(frete)).toFreteDomain();
    }

    @Override
    public void removerFrete(Long id) {
        var frete = freteRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException(id));
        freteRepository.delete(frete);
    }
}
