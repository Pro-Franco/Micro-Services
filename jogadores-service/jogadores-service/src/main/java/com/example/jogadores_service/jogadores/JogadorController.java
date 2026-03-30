package com.example.jogadores_service.jogadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorRepository repository;

    @GetMapping
    public List<Jogador> getAllJogadores() {
        return repository.findAll();
    }

    @PostMapping
    public Jogador createJogador(@RequestBody Jogador jogador) {
        return repository.save(jogador);
    }
}
