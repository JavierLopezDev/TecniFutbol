package com.dam.tecnifutbol.Entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

public class SeleccionDeEquipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_equipos);
        TextView tv_Editar=findViewById(R.id.tv_Editar);
        TextView tv_Partido=findViewById(R.id.tv_Partido);
       // tv_Editar.setBackgroundResource();
    }
}