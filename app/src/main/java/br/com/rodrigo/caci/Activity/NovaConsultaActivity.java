package br.com.rodrigo.caci.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import br.com.rodrigo.caci.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NovaConsultaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_consulta);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.buttonData) void getData(){

    }
}
