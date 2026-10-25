package com.example.healthpoints;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button botaoCriarConta;
    Button botaoEntrar;

    EditText campoEmail;
    EditText campoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // Liga os campos do Java aos campos do XML
        campoEmail = findViewById(R.id.edtEmail);
        campoSenha = findViewById(R.id.edtSenha);

        botaoEntrar = findViewById(R.id.btnEntrar);
        botaoCriarConta = findViewById(R.id.btnCriarConta);


        // BOTÃO CRIAR CONTA
        botaoCriarConta.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    CadastroActivity.class
            );

            startActivity(intent);
        });


        // BOTÃO ENTRAR
        botaoEntrar.setOnClickListener(v -> {

            String email = campoEmail.getText().toString().trim();
            String senha = campoSenha.getText().toString().trim();


            // Verifica se o e-mail foi preenchido
            if (email.isEmpty()) {
                campoEmail.setError("Digite seu e-mail");
                return;
            }


            // Verifica se a senha foi preenchida
            if (senha.isEmpty()) {
                campoSenha.setError("Digite sua senha");
                return;
            }


            // Acessa o banco de dados
            BancoDados bancoDados =
                    BancoDados.getInstance(MainActivity.this);


            // Acessa o DAO
            UsuarioDAO usuarioDAO =
                    bancoDados.usuarioDAO();


            // Procura o usuário pelo e-mail e senha
            Usuario usuario =
                    usuarioDAO.fazerLogin(email, senha);


            // Se encontrou o usuário
            if (usuario != null) {

                Toast.makeText(
                        MainActivity.this,
                        "Login realizado com sucesso!",
                        Toast.LENGTH_SHORT
                ).show();


                // Prepara a abertura do Dashboard
                Intent intent = new Intent(
                        MainActivity.this,
                        DashboardActivity.class
                );


                // Envia as informações do usuário logado
                intent.putExtra("usuarioId", usuario.getId());
                intent.putExtra("usuarioNome", usuario.getNome());


                startActivity(intent);


                // Fecha a tela de Login
                finish();

            } else {

                Toast.makeText(
                        MainActivity.this,
                        "E-mail ou senha incorretos",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}