package io.github.kauanmedeirosss.Vestuario.API.controller;

import io.github.kauanmedeirosss.Vestuario.API.controller.dto.DadosCadastroVestimenta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vestimentas")
public class VestimentaController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroVestimenta dados){
        System.out.println(dados);
    }

}