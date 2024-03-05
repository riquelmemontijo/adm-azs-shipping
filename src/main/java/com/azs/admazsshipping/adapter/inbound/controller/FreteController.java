package com.azs.admazsshipping.adapter.inbound.controller;

import com.azs.admazsshipping.adapter.inbound.controller.request.FreteRequestAtualizarDTO;
import com.azs.admazsshipping.adapter.inbound.controller.request.FreteRequestDTO;
import com.azs.admazsshipping.adapter.inbound.controller.response.FreteResponseDTO;
import com.azs.admazsshipping.domain.domain.Frete;
import com.azs.admazsshipping.domain.domain.Paginacao;
import com.azs.admazsshipping.domain.ports.inbound.FreteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/frete")
public class FreteController {

    private final FreteUseCasePort freteUseCase;

    public FreteController(FreteUseCasePort freteUseCase) {
        this.freteUseCase = freteUseCase;
    }

    @PostMapping
    public ResponseEntity<FreteResponseDTO> cadastrarFrete(@Valid @RequestBody FreteRequestDTO freteRequestDTO, UriComponentsBuilder uriBuilder){
        var freteResponseDTO = FreteResponseDTO.fromFreteDomain(freteUseCase.cadastrarFrete(freteRequestDTO.toFreteDomain()));
        var uri = uriBuilder.path("/frete/{id}")
                            .buildAndExpand(freteResponseDTO.getId())
                            .toUri();
        return ResponseEntity.created(uri).body(freteResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<FreteResponseDTO>> buscarFretes(@RequestParam("pagina") Integer pagina,
                                                               @RequestParam("tamanho") Integer tamanho,
                                                               @RequestParam("parametro") String parametro){
        var paginacao = new Paginacao(tamanho, pagina);
        List<FreteResponseDTO> fretes = freteUseCase.buscarFretes(paginacao, parametro).stream().map(FreteResponseDTO::fromFreteDomain).toList();
        Page<FreteResponseDTO> page = new PageImpl<>(fretes, PageRequest.of(paginacao.pagina(), paginacao.tamanho()), fretes.size());
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<FreteResponseDTO> atualizarFrete(@Valid @RequestBody FreteRequestAtualizarDTO freteRequestAtualizarDTO){
        Frete frete = freteUseCase.atualizarFrete(freteRequestAtualizarDTO.toFreteDomain());
        return ResponseEntity.ok(FreteResponseDTO.fromFreteDomain(frete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerFrete(@PathVariable Long id){
        freteUseCase.removerFrete(id);
        return ResponseEntity.noContent().build();
    }

}
