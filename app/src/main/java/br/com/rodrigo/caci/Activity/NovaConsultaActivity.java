package br.com.rodrigo.caci.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

import br.com.rodrigo.caci.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NovaConsultaActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    int dia, mes, ano, hora, minuto;
    int diaFinal, mesFinal, anoFinal, horaFinal, minutoFinal;
    Date date;

    @BindView(R.id.editTextHora)
    EditText editTextHoraConsulta;
    @BindView(R.id.editTextData)
    EditText editTextDataConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_consulta);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.buttonData) void getData(){
        Calendar data = Calendar.getInstance();
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, ano, mes, dia);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        anoFinal = i;
        mesFinal = i1 + 1;
        diaFinal = i2;
        Calendar calendar = Calendar.getInstance();
        hora = calendar.get(Calendar.HOUR);
        minuto = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(NovaConsultaActivity.this, NovaConsultaActivity.this,
                hora, minuto, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
}

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        horaFinal = i;
        minutoFinal = i1;

        editTextDataConsulta.setText(diaFinal+"/"+mesFinal+"/"+anoFinal);
        editTextHoraConsulta.setText(horaFinal+":"+minutoFinal);
    }
}
