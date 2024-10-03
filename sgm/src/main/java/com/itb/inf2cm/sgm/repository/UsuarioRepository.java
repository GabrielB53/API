package com.itb.inf2cm.sgm.repository;


import com.itb.inf2cm.sgm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findAllById(long id);
}
