package br.com.rodrigo.caci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import br.com.rodrigo.caci.Adapter.ConsultaAdapter;
import br.com.rodrigo.caci.Model.Consulta;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ConsultaAdapter consultaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView_Consultas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Consulta consulta = new Consulta();
        consulta.setData("02/09/2019");
        consulta.setDiaSemana("Segunda-Feira");
        consulta.setHorario("15:30");
        consulta.setNomePaciente("Rodrigo Boza");
        consulta.setNomeMedico("Dr. Hivan");


        consultas.add(consulta);
        consultaAdapter = new ConsultaAdapter(consultas, this);
        recyclerView.setAdapter(consultaAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_mes_anterior:
                return true;
            case R.id.item_proximo_mes:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
