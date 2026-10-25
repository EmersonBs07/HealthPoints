package com.example.healthpoints;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView textoSaudacao;
    TextView textoPontos;

    Button botaoAgua;
    Button botaoSono;
    Button botaoMetas;
    Button botaoHistorico;
    Button botaoPerfil;
    Button botaoInicio;

    int usuarioId;
    String usuarioNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        // Textos
        textoSaudacao = findViewById(R.id.txtSaudacao);
        textoPontos = findViewById(R.id.txtPontos);

        // Botões
        botaoAgua = findViewById(R.id.btnAgua);
        botaoSono = findViewById(R.id.btnSono);
        botaoMetas = findViewById(R.id.btnMetas);
        botaoHistorico = findViewById(R.id.btnHistorico);
        botaoPerfil = findViewById(R.id.btnPerfil);
        botaoInicio = findViewById(R.id.btnInicio);

        // Recebe o usuário que fez login
        usuarioId = getIntent().getIntExtra("usuarioId", -1);
        usuarioNome = getIntent().getStringExtra("usuarioNome");

        // Mostra o nome
        if (usuarioNome != null) {
            textoSaudacao.setText("Olá, " + usuarioNome + " 👋");
        } else {
            textoSaudacao.setText("Olá! 👋");
        }

        // Pontos iniciais
        textoPontos.setText("0 pontos");

        // ÁGUA
        botaoAgua.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "+250 ml de água",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // SONO
        botaoSono.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "Registrar sono",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // METAS
        botaoMetas.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "Metas",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // HISTÓRICO
        botaoHistorico.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "Histórico",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // PERFIL
        botaoPerfil.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "Perfil",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // INÍCIO
        botaoInicio.setOnClickListener(v -> {
            Toast.makeText(
                    DashboardActivity.this,
                    "Você já está no início",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}