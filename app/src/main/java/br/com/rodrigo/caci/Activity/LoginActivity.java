package br.com.rodrigo.caci.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.rodrigo.caci.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextLoginId)
    EditText editTextUserID;
    @BindView(R.id.editTextLoginSenha)
    EditText editTextUserSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonLogin) void login(){
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }
}
