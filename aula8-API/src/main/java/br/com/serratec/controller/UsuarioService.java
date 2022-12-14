package br.com.serratec.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.serratec.dto.UsuarioDTO;
import br.com.serratec.dto.UsuarioInserirDTO;
import br.com.serratec.exception.EmailException;
import br.com.serratec.exception.SenhaException;
import br.com.serratec.model.Perfil;
import br.com.serratec.model.Usuario;
import br.com.serratec.model.UsuarioPerfil;
import br.com.serratec.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilService perfilService;

    @Transactional
    public List<UsuarioDTO> lista(){
        List<Usuario>usuarios = usuarioRepository.findAll();
        List<UsuarioDTO>usuarioDTO = new ArrayList<>();
        for(Usuario usuario: usuarios){
            usuarioDTO.add(new UsuarioDTO(usuario));
        }
        return usuarioDTO;
    }
    

    public UsuarioDTO inserir(UsuarioInserirDTO user) throws EmailException {
        if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
            throw new SenhaException("Senha e Confirma Senha não são iguais");
        }
        if (usuarioRepository.findByEmail(user.getEmail())!=null) {
            throw new EmailException("Email já existente");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(user.getNome());
        usuario.setEmail(user.getEmail());
        usuario.setSenha(user.getSenha());
        
        Set<UsuarioPerfil> perfis = new HashSet<>();
        for(Perfil perfil: user.getPerfis()) {
            perfil = perfilService.buscar(perfil.getId());
            UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
            perfis.add(usuarioPerfil);
        }
        usuario.setUsuarioPerfis(perfis);
        usuario = usuarioRepository.save(usuario);
        
        return new UsuarioDTO(usuario);
    }

    // public UsuarioDTO inserir(UsuarioInserirDTO user) throws EmailException {
    //     if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
    //         throw new SenhaException("Senha e Confirma Senha não são iguais");
    //     }
    //     if (usuarioRepository.findByEmail(user.getEmail())!=null) {
    //         throw new EmailException("Email já existente");
    //     }
    //     Usuario usuario = new Usuario();
    //     usuario.setNome(user.getNome());
    //     usuario.setEmail(user.getEmail());
    //     usuario.setSenha((user.getSenha()));
    //     return new UsuarioDTO(usuarioRepository.save(usuario));
    // }
}
