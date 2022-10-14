package br.com.serratec.dto;

import java.util.Set;

import br.com.serratec.model.Perfil;
import br.com.serratec.model.Usuario;

public class UsuarioDTO {
    
    private Long id;
    private String nome;
    private String email;

    private Set<Perfil> perfis;
    
    public UsuarioDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    public UsuarioDTO() {
    }
    
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
