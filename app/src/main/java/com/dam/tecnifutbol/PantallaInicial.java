package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dam.tecnifutbol.Entrenador.PantallaEntrenador;
import com.dam.tecnifutbol.Jugador.PantallaSeleccionEntrenamiento;

public class PantallaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);
        LinearLayout entrenador = findViewById(R.id.ly_entrenador);
        LinearLayout jugador = findViewById(R.id.ly_jugador);


        entrenador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            Intent intent = new Intent(this, PantallaEntrenador.class);
            startActivity(intent);
        });

        jugador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            Intent intent = new Intent(this, PantallaSeleccionEntrenamiento.class);
            startActivity(intent);
        });


    }
}