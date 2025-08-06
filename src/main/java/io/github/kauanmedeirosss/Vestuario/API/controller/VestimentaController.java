package io.github.kauanmedeirosss.Vestuario.API.controller;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.CadastroVestimentaDTO;
import io.github.kauanmedeirosss.Vestuario.API.model.Vestimenta;
import io.github.kauanmedeirosss.Vestuario.API.repository.VestimentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vestimentas")
public class VestimentaController {

    @Autowired
    private VestimentaRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody CadastroVestimentaDTO dto){
        repository.save(new Vestimenta(dto));
    }

}