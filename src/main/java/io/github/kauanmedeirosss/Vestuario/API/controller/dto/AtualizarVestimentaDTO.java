package io.github.kauanmedeirosss.Vestuario.API.controller.dto;

import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tamanho;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AtualizarVestimentaDTO(
        @NotNull(message = "Campo obrigatório!")
        Long id,
        @Enumerated
        @Size(min = 1, max = 2, message = "Campo fora do tamanho padrão.")
        Tamanho tamanho,
        @Positive(message = "Não pode ser um valor negativo.")
        Double preco) {

}
