package com.example.healthpoints;

public class CadastroUsuario {

    public Usuario cadastrar(String nome, String email, String senha,String peso, String altura, String dataNascimento) {

        Usuario usuario = new Usuario(nome, email, senha, peso, altura, dataNascimento);

        return usuario;
    }
}