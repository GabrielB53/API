package com.itb.inf2cm.sgm.service;

import java.util.List;

import com.itb.inf2cm.sgm.exceptions.NotFound;
import com.itb.inf2cm.sgm.model.Usuario;
import com.itb.inf2cm.sgm.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    // Criar objeto repository
    final UsuarioRepository usuarioRepository;

    // Injeção de Dependência
    public UsuarioService(UsuarioRepository _usuarioRepository) {
        this.usuarioRepository = _usuarioRepository;
    }

    // Método para salvar o usuário
    @Transactional
    public Usuario save(Usuario _usuario) {
        return usuarioRepository.save(_usuario);
    }

    // Método para listar todos os usuários
    public List<Usuario> findAll(){
        List<Usuario> lista = usuarioRepository.findAll();
        return lista;
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Transactional
    public Usuario update(Usuario usuario) {
        Usuario existingUser = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new NotFound("Usuário não encontrado"));
        existingUser.setNome(usuario.getNome());
        existingUser.setEmail(usuario.getEmail());
        return usuarioRepository.save(existingUser);
    }

    @Transactional
    public boolean delete(Usuario _usuario) {
        boolean sucesso = false;
        Usuario usuarioEncontrado = usuarioRepository.findAllById(_usuario.getId());
        if(usuarioEncontrado.getId() > 0) {
            usuarioRepository.deleteById(usuarioEncontrado.getId());
            sucesso = true;
        }

        return sucesso;
    }
}
