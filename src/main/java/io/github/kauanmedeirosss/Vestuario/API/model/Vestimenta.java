package io.github.kauanmedeirosss.Vestuario.API.model;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.AtualizarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.CadastrarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tamanho;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "vestimenta")
@Table(name = "vestimentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vestimenta {

    public Vestimenta(CadastrarVestimentaDTO dto){
        this.nome = dto.nome();
        this.cor = dto.cor();
        this.tamanho = dto.tamanho();
        this.tipo = dto.tipo();
        this.loja = dto.loja();
        this.preco = dto.preco();
        this.ativa = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cor;

    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String loja;

    private Double preco;

    private Boolean ativa;

    public void atualizarInformacoes(@Valid AtualizarVestimentaDTO dto){
        if(dto.tamanho() != null){
            this.tamanho = dto.tamanho();
        }
        if(dto.preco() != null){
            this.preco = dto.preco();
        }
    }

    public void inativar(){
        this.ativa = false;
    }

    public void ativar(){
        this.ativa = true;
    }

}
