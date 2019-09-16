package br.com.rodrigo.caci.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.rodrigo.caci.Adapter.ConsultaAdapter;
import br.com.rodrigo.caci.Model.Consulta;
import br.com.rodrigo.caci.R;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ConsultaAdapter consultaAdapter;
    private Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewConsultas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getMonth(calendar);

        Consulta consulta = new Consulta();
        consulta.setData("02/09/2019");
        consulta.setDiaSemana("Segunda-Feira");
        consulta.setHorario("15:30");
        consulta.setNomePaciente("Rodrigo Boza");
        consulta.setNomeMedico("Dr. José");
        consultas.add(consulta);

        Consulta consulta1 = new Consulta();
        consulta1.setData("03/09/2019");
        consulta1.setDiaSemana("Segunda-Feira");
        consulta1.setHorario("10:00");
        consulta1.setNomePaciente("Mirmidão de Pompeia");
        consulta1.setNomeMedico("Dr. Dante");
        consultas.add(consulta1);

        consultaAdapter = new ConsultaAdapter(consultas, this);
        recyclerView.setAdapter(consultaAdapter);

        novaConsulta();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_mes_anterior:
                //otimizar metodo para voltar o mês exibido
                calendar.add(Calendar.MONTH, -1);
                getMonth(calendar);
                return true;
            case R.id.item_proximo_mes:
                //otimizar metodo para avançar mês exibido
                calendar.add(Calendar.MONTH, 1);
                getMonth(calendar);
                return true;
            case R.id.item_logOut:
                //criar metodo para sair da conta do app
                Toast.makeText(MainActivity.this, "Sair da conta atual", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void novaConsulta() {
        FloatingActionButton buttonNovaConsulta = findViewById(R.id.floatButtonNovaConsulta);
        buttonNovaConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NovaConsultaActivity.class));
            }
        });
    }


    private void getMonth(Calendar calendar) {
        Calendar data = Calendar.getInstance();
        data.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        data.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        String format = new SimpleDateFormat("MMMM yyyy").format(data.getTime());
        String upcase = format.substring(0,1).toUpperCase() + format.substring(1);
        getSupportActionBar().setTitle(upcase);
    }
}
