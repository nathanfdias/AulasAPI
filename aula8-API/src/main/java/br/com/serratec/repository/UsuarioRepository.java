package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
     
    Usuario findByEmail(String email);
}
