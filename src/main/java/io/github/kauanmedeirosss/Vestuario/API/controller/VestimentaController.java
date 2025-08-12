package io.github.kauanmedeirosss.Vestuario.API.controller;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.AtualizarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.CadastrarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.controller.dto.RetornarVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import io.github.kauanmedeirosss.Vestuario.API.repository.VestimentaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vestimentas")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastrarVestimentaDTO dto){
        repository.save(new Vestimenta(dto));
    }

    @GetMapping
    public List<RetornarVestimentaDTO> listar(){
        return repository.findAll().stream().map(RetornarVestimentaDTO::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarVestimentaDTO dto){
        var vest = repository.getReferenceById(dto.id());
        vest.atualizarInformacoes(dto);
    }

    /*
    @DeleteMapping
    public
    */
    
}