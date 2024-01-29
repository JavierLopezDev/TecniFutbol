package com.dam.tecnifutbol.Entrenador;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        //Cuando seleccione btn_Partidos me llevara a la actividad de seleccionDeEquipos

    }
}