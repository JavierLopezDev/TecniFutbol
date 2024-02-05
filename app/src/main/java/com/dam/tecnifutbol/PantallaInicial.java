package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dam.tecnifutbol.Entrenador.PantallaEntrenador;

public class PantallaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);
        TextView etEntrenador = findViewById(R.id.et_entrenador);
        TextView etJugador = findViewById(R.id.et_jugador);


        etEntrenador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            Intent intent = new Intent(this, PantallaEntrenador.class);
            startActivity(intent);
        });


    }
}