package br.com.rodrigo.caci.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.rodrigo.caci.Activity.DescricaoConsultaActivity;
import br.com.rodrigo.caci.Model.Consulta;
import br.com.rodrigo.caci.R;

public class ConsultaAdapter extends RecyclerView.Adapter<ConsultaAdapter.ConsultaViewHolder> {
    private ArrayList<Consulta> consultas;
    private Context context;

    public ConsultaAdapter(ArrayList<Consulta> consultas, Context context) {
        this.consultas = consultas;
        this.context = context;
    }

    @NonNull
    @Override
    public ConsultaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_consulta, viewGroup, false);
        return new ConsultaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultaViewHolder consultaViewHolder, int posicao) {
        final Consulta consulta = consultas.get(posicao);

        consultaViewHolder.textViewData.setText(consulta.getData());
        consultaViewHolder.textViewDiaSemana.setText(consulta.getDiaSemana());
        consultaViewHolder.textViewHorario.setText(consulta.getHorario());
        consultaViewHolder.textViewNomeMedico.setText(consulta.getNomeMedico());
        consultaViewHolder.textViewNomePaciente.setText(consulta.getNomePaciente());

        consultaViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescricaoConsultaActivity.class);
                intent.putExtra("nomePaciente", consulta.getNomePaciente());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return consultas.size();
    }

    public class ConsultaViewHolder extends RecyclerView.ViewHolder {
        TextView textViewData;
        TextView textViewDiaSemana;
        TextView textViewHorario;
        TextView textViewNomePaciente;
        TextView textViewNomeMedico;

        public ConsultaViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewData = itemView.findViewById(R.id.textViewDia);
            textViewDiaSemana = itemView.findViewById(R.id.textViewDiaDaSemana);
            textViewHorario = itemView.findViewById(R.id.textViewHorario);
            textViewNomeMedico = itemView.findViewById(R.id.textViewNomeMedico);
            textViewNomePaciente = itemView.findViewById(R.id.textViewNomePaciente);
        }
    }
}
