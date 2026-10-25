package com.example.healthpoints;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UsuarioDAO {

    @Insert
    void cadastrar(Usuario usuario);
    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha LIMIT 1")
    Usuario fazerLogin(String email, String senha);
}
