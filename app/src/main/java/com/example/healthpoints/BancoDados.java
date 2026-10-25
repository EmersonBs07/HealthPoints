package com.example.healthpoints;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {Usuario.class},
        version = 1,
        exportSchema = false
)
public abstract class BancoDados extends RoomDatabase {

    public abstract UsuarioDAO usuarioDAO();

    private static BancoDados instancia;

    public static synchronized BancoDados getInstance(Context context) {

        if (instancia == null) {

            instancia = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BancoDados.class,
                    "health_points_db"
            ).allowMainThreadQueries().build();
        }

        return instancia;
    }
}