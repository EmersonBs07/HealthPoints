package com.example.healthpoints;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText campoNome;
    EditText campoEmail;
    EditText campoDataNascimento;
    EditText campoPeso;
    EditText campoAltura;
    EditText campoSenha;

    Button botaoCadastrar;
    Button botaoVoltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.edtNome);
        campoEmail = findViewById(R.id.edtEmailCadastro);
        campoDataNascimento = findViewById(R.id.edtDataNascimento);
        campoPeso = findViewById(R.id.edtPeso);
        campoAltura = findViewById(R.id.edtAltura);
        campoSenha = findViewById(R.id.edtSenhaCadastro);

        botaoCadastrar = findViewById(R.id.btnCadastrar);
        botaoVoltarLogin = findViewById(R.id.btnVoltarLogin);
    }
}