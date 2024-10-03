package com.itb.inf2cm.sgm.model;

import jakarta.persistence.*;

@Entity
@Table(name="Usuario")
public class Usuario {

    public Usuario() {
    }

    public Usuario(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = true, length = 20)
    private String tipoUsuario;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Transient
    private String mensagemErro = "";

    @Transient
    private boolean isValid = true;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarUsuario() {
        if (nome == null || nome.isEmpty()) {
            mensagemErro += "O nome do usuário é obrigatório";
            isValid = false;
        }
        return isValid;
    }
}
