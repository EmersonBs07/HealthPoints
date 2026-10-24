package com.example.healthpoints;

public class CadastroUsuario {

    public Usuario cadastrar(String nome, String email, String senha,double peso, double altura, int idade) {

        Usuario usuario = new Usuario(nome, email, senha, peso, altura, idade);

        return usuario;
    }
}