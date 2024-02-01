package com.dam.tecnifutbol.Entrenador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.tecnifutbol.Entrenador.Entrenamientos.PantallaEntrenamientos;
import com.dam.tecnifutbol.Entrenador.Partidos.SeleccionDeEquipos;
import com.dam.tecnifutbol.R;

public class PantallaEntrenador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenador);
        TextView tv_Entrenamientos=findViewById(R.id.tv_Entrenamientos);
        TextView tv_Partidos=findViewById(R.id.tv_Partidos);
        TextView tvTituloEntrenador=findViewById(R.id.tv_TituloEntrenador);

        tv_Entrenamientos.setBackgroundResource(R.drawable.boton);
        tv_Partidos.setBackgroundResource(R.drawable.boton);

        tv_Entrenamientos.setOnClickListener(v -> {

            Intent intent = new Intent(this, PantallaEntrenamientos.class);
            startActivity(intent);
        });
        tv_Partidos.setOnClickListener(v -> {

            Intent intent = new Intent(this, SeleccionDeEquipos.class);
            startActivity(intent);
        });
        //Cuando seleccione btn_Partidos me llevara a la actividad de seleccionDeEquipos

    }
}