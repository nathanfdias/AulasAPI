package br.com.serratec.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.serratec.dto.UsuarioDTO;
import br.com.serratec.dto.UsuarioInserirDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        return ResponseEntity.ok(usuarioService.lista());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioInserirDTO usuario) {
        UsuarioDTO usuarioDTO = usuarioService.inserir(usuario);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(usuarioDTO.getId())
            .toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }
}
