package io.github.kauanmedeirosss.Vestuario.API.controller;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.AtualizarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.CadastrarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.DetalhamentoVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.RetornarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import io.github.kauanmedeirosss.Vestuario.API.repository.VestimentaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/vestimentas")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoVestimentaDTO> cadastrar(@RequestBody @Valid CadastrarVestimentaDTO dto, UriComponentsBuilder uriBuilder){
        var vest = new Vestimenta(dto);
        repository.save(vest);

        var uri = uriBuilder.path("/vestimentas/{id}").buildAndExpand(vest.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoVestimentaDTO(vest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoVestimentaDTO> buscar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoVestimentaDTO(vest));
    }

    @GetMapping
    public ResponseEntity<List<RetornarVestimentaDTO>> listar(){
        var lista = repository.findAllByAtivaTrue().stream().map(RetornarVestimentaDTO::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoVestimentaDTO> atualizar(@RequestBody @Valid AtualizarVestimentaDTO dto){
        var vest = repository.getReferenceById(dto.id());
        vest.atualizarInformacoes(dto);

        return ResponseEntity.ok(new DetalhamentoVestimentaDTO(vest));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar(@PathVariable Long id){
        var vest = repository.getReferenceById(id);
        vest.ativar();

        return ResponseEntity.noContent().build();
    }

}