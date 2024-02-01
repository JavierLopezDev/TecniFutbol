package com.dam.tecnifutbol.Entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

public class SeleccionDeEquipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_equipos);
        TextView tv_Editar=findViewById(R.id.tv_Editar);
        TextView tv_Partido=findViewById(R.id.tv_Partido);
        tv_Editar.setBackgroundResource(R.drawable.boton);
        tv_Partido.setBackgroundResource(R.drawable.boton);

        ImageButton ib_CrearEquipo=findViewById(R.id.imageButton_NuevoEquipo);
        ib_CrearEquipo.setOnClickListener(v -> {
            //Nos movemos a la pantalla de crear equipo
            setContentView(R.layout.activity_crear_equipo);
            Intent intent = new Intent(this, CrearEquipo.class);
            startActivity(intent);
        });

    }
}