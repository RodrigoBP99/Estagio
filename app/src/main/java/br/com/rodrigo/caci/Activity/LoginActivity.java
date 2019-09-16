package br.com.rodrigo.caci.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.rodrigo.caci.R;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editTextUserID;
    private EditText editTextUserSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewsById();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void findViewsById() {
        editTextUserID = findViewById(R.id.editTextLoginId);
        editTextUserSenha = findViewById(R.id.editTextLoginSenha);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
}
