package io.github.kauanmedeirosss.Vestuario.API.controller.dto;

import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tamanho;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CadastroVestimentaDTO(
        @NotBlank(message = "Campo obrigatório!")
        String nome,
        @NotBlank(message = "Campo obrigatório!")
        String cor,
        @Enumerated
        @NotBlank(message = "Campo obrigatório!")
        @Size(min = 1, max = 2, message = "Campo fora do tamanho padrão.")
        Tamanho tamanho,
        @Enumerated
        @NotBlank(message = "Campo obrigatório!")
        Tipo tipo,
        @NotBlank(message = "Campo obrigatório!")
        String loja,
        @Positive(message = "Não pode ser um valor negativo.")
        Double preco) {
}
