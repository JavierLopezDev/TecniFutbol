package com.dam.tecnifutbol.Entrenador;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int año=c.get(Calendar.YEAR);
        int mes=c.get(Calendar.MONTH);
        int dia=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,año,mes,dia);
    }
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GregorianCalendar g=new GregorianCalendar(i,i2,i3);
        EditText edtFecha = getActivity().findViewById(R.id.et_fechaNacJugadorInsertado);
        edtFecha.setText(i3 + "/" + (i2 + 1) + "/" + i );
        MainActivity.fechaNacJugadorInsertado = i3 + "/" + (i2 + 1) + "/" + i;
    }

}
