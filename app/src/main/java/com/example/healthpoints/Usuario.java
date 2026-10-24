package com.example.healthpoints;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private double peso;
    private double altura;
    private int idade;

    public Usuario(String nome, String email, String senha,
                   double peso, double altura, int idade) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
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

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }
}