package com.itb.inf2cm.sgm.control;

import com.itb.inf2cm.sgm.exceptions.NotFound;
import com.itb.inf2cm.sgm.model.Usuario;
import com.itb.inf2cm.sgm.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/usuarionovo")
public class UsuarioController {

    final UsuarioService usuarioService;

    // Injeção de Dependência
    public UsuarioController(UsuarioService _usuarioService) {
        this.usuarioService = _usuarioService;
    }

    // ROTA POST
    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.save(usuario));
    }

    // ROTA GET
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.update(usuario));
    }
    @DeleteMapping
    public ResponseEntity<Object> deleteProduto(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.delete(usuario));
    }


}
