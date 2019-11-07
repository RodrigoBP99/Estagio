package br.com.rodrigo.caci.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import br.com.rodrigo.caci.R;

public class DescricaoConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_conquista);

        Intent intent = getIntent();
        String titulo = intent.getExtras().getString("nomePaciente");

        getSupportActionBar().setTitle(titulo);
    }
}
