package br.com.serratec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.UsuarioDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.model.Usuario;
import br.com.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> lista(){
        List<Usuario>usuarios = usuarioRepository.findAll();
        List<UsuarioDTO>usuarioDTO = new ArrayList<>();
        for(Usuario usuario: usuarios){
            usuarioDTO.add(new UsuarioDTO(usuario));
        }
        return usuarioDTO;
    }
    
    public Usuario inserir(Usuario user) throws EmailException {
        Usuario usuario = usuarioRepository.findByEmail(user.getEmail());
        if (usuario!=null) {
            throw new EmailException("Email já existente");
        }
        return usuarioRepository.save(user);
    }
}
