package io.github.kauanmedeirosss.Vestuario.API.controller.dto;

import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tamanho;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;

public record DetalhamentoVestimentaDTO(
        Long id,
        String nome,
        String cor,
        Tamanho tamanho,
        Tipo tipo,
        String loja,
        Double preco,
        Boolean ativa

) {
    public DetalhamentoVestimentaDTO(Vestimenta vestimenta){
        this(vestimenta.getId(),
                vestimenta.getNome(),
                vestimenta.getCor(),
                vestimenta.getTamanho(),
                vestimenta.getTipo(),
                vestimenta.getLoja(),
                vestimenta.getPreco(),
                vestimenta.getAtiva());
    }
}
