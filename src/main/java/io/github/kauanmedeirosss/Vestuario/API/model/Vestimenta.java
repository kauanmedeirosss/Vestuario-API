package io.github.kauanmedeirosss.Vestuario.API.model;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.CadastroVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tamanho;
import io.github.kauanmedeirosss.Vestuario.API.model.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "vestimenta")
@Table(name = "vestimentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vestimenta {

    public Vestimenta(CadastroVestimentaDTO dto){
        this.nome = dto.nome();
        this.cor = dto.cor();
        this.tamanho = dto.tamanho();
        this.tipo = dto.tipo();
        this.loja = dto.loja();
        this.preco = dto.preco();
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

}
