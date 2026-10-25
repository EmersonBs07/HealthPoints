package com.example.healthpoints;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        // Liga as variáveis Java aos campos do XML
        campoNome = findViewById(R.id.edtNome);
        campoEmail = findViewById(R.id.edtEmailCadastro);
        campoDataNascimento = findViewById(R.id.edtDataNascimento);
        campoPeso = findViewById(R.id.edtPeso);
        campoAltura = findViewById(R.id.edtAltura);
        campoSenha = findViewById(R.id.edtSenhaCadastro);

        botaoCadastrar = findViewById(R.id.btnCadastrar);
        botaoVoltarLogin = findViewById(R.id.btnVoltarLogin);

        // Executa quando o usuário clicar em CADASTRAR
        botaoCadastrar.setOnClickListener(v -> {

            // Pega os dados digitados
            String nome = campoNome.getText().toString().trim();
            String email = campoEmail.getText().toString().trim();
            String dataNascimento = campoDataNascimento.getText().toString().trim();
            String peso = campoPeso.getText().toString().trim();
            String altura = campoAltura.getText().toString().trim();
            String senha = campoSenha.getText().toString().trim();

            // Validação do nome
            if (nome.isEmpty()) {
                campoNome.setError("Digite seu nome");
                return;
            }

            // Validação do e-mail
            if (email.isEmpty()) {
                campoEmail.setError("Digite seu e-mail");
                return;
            }

            // Validação da data de nascimento
            if (dataNascimento.isEmpty()) {
                campoDataNascimento.setError("Digite sua data de nascimento");
                return;
            }

            // Validação do peso
            if (peso.isEmpty()) {
                campoPeso.setError("Digite seu peso");
                return;
            }

            // Validação da altura
            if (altura.isEmpty()) {
                campoAltura.setError("Digite sua altura");
                return;
            }

            // Validação da senha
            if (senha.isEmpty()) {
                campoSenha.setError("Digite sua senha");
                return;
            }

            // Converte peso e altura de String para double
            double pesoDouble = Double.parseDouble(peso);
            double alturaDouble = Double.parseDouble(altura);

            // Cria o objeto Usuario com os dados preenchidos
            Usuario usuario = new Usuario(
                    nome,
                    email,
                    senha,
                    pesoDouble,
                    alturaDouble,
                    dataNascimento
            );
            BancoDados bancoDados =
                    BancoDados.getInstance(CadastroActivity.this);

            UsuarioDAO usuarioDAO =
                    bancoDados.usuarioDAO();

            usuarioDAO.cadastrar(usuario);

            // Mostra uma mensagem
            Toast.makeText(
                    CadastroActivity.this,
                    "Conta criada com sucesso!",
                    Toast.LENGTH_SHORT
            ).show();

            // Volta para a tela de login
            Intent intent = new Intent(
                    CadastroActivity.this,
                    MainActivity.class
            );

            startActivity(intent);

            // Fecha a tela de cadastro
            finish();
        });

        // Botão para voltar ao login sem cadastrar
        botaoVoltarLogin.setOnClickListener(v -> {
            finish();
        });
    }
}