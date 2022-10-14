package br.com.serratec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.model.Perfil;
import br.com.serratec.repository.PerfilRepository;

@Service
public class PerfilService {
   
    @Autowired
    private PerfilRepository perfilRepository;
    
    public Perfil buscar(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.get();
    }
}