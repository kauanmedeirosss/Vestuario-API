package io.github.kauanmedeirosss.Vestuario.API.controller.dto;

import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;

public record RetornarVestimentaDTO(
        Long id,
        String nome,
        String cor,
        Tipo tipo,
        String loja
) {
    public RetornarVestimentaDTO(Vestimenta vestimenta){
        this(vestimenta.getId(),
                vestimenta.getNome(),
                vestimenta.getCor(),
                vestimenta.getTipo(),
                vestimenta.getLoja());
    }
}
