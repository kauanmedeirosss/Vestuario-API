package io.github.kauanmedeirosss.Vestuario.API.controller.dto;

import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;

public record CadastroVestimentaDTO(
        String nome,
        String cor,
        Tipo tipo,
        String loja) {
}
