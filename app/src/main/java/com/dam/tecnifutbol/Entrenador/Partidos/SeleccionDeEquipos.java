package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        tv_Editar.setBackgroundResource(R.drawable.boton);
        tv_Partido.setBackgroundResource(R.drawable.boton);

        tv_Partido.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            Intent intent = new Intent(this, SeleccionTipoPartido.class);
            startActivity(intent);
        });

    }
}