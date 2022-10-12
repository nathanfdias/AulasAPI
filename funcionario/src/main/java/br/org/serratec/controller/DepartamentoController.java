package br.org.serratec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.org.serratec.model.Departamento;
import br.org.serratec.repository.DepartamentoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> listar(){
        return departamentoRepository.findAll();
    }

    @PostMapping(value = "/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Departamento create(@RequestBody Departamento departamento){
        return departamentoRepository.save(departamento);
    }
}
