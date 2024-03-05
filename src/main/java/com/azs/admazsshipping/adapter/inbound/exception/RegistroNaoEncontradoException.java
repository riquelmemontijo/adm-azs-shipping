package com.azs.admazsshipping.adapter.inbound.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(Long id){
        super("Registro não encontrado com o id: " + id);
    }

}
