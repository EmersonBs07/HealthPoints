package com.example.healthpoints;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String peso;
    private String altura;
    private String dataNascimento;

    public Usuario(String nome, String email, String senha,
                   String peso, String altura, String dataNascimento) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getPeso() {
        return peso;
    }

    public String getAltura() {
        return altura;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}