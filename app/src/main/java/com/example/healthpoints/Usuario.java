package com.example.healthpoints;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String email;
    private String senha;
    private double peso;
    private double altura;
    private String dataNascimento;

    public Usuario(String nome, String email, String senha,
                   double peso, double altura, String dataNascimento) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.peso = peso;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }
}