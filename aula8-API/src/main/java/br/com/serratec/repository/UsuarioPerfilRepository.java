package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.model.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long>{
    
}
