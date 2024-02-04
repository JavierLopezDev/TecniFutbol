package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

public class Partido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido);

        Intent intent = getIntent();
        Equipo equipo1 = (Equipo) intent.getSerializableExtra("equipo1");
        Equipo equipo2 = (Equipo) intent.getSerializableExtra("equipo2");
        TextView nombreEqquipo1=findViewById(R.id.tv_NombreEquipo1);
        TextView nombreEqquipo2=findViewById(R.id.tv_NombreEquipo2);

        nombreEqquipo1.setText(equipo1.getNombre());
        nombreEqquipo2.setText(equipo2.getNombre());

    }
}