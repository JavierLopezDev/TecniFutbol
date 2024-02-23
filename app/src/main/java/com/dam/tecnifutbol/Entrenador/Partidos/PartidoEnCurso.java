package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dam.tecnifutbol.Modelo.Equipo;
import com.dam.tecnifutbol.R;

public class PartidoEnCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_en_curso);
        Intent intent = getIntent();
        Equipo equipo1 = (Equipo) intent.getSerializableExtra("equipo1");
        Equipo equipo2 = (Equipo) intent.getSerializableExtra("equipo2");
        TextView nombreEqquipo1=findViewById(R.id.tv);
        TextView nombreEqquipo2=findViewById(R.id.tv2);

        nombreEqquipo1.setText(equipo1.getNombre());
        nombreEqquipo2.setText(equipo2.getNombre());
    }

    @Override
    public void onBackPressed() {
    }
}