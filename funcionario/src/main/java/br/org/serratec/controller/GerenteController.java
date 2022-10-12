package br.org.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import br.org.serratec.model.Gerente;
import br.org.serratec.repository.GerenteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/gerentes")
public class GerenteController {
    @Autowired
    private GerenteRepository gerenteRepository;

    @GetMapping
    public List<Gerente> listar(){
        return gerenteRepository.findAll();
    }

    @PostMapping(value="/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Gerente post(@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }
    
}
