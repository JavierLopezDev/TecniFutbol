package com.dam.tecnifutbol.Entrenador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.tecnifutbol.Entrenador.Partidos.SeleccionDeEquipos;
import com.dam.tecnifutbol.LoginFirebase;
import com.dam.tecnifutbol.R;

public class PantallaEntrenador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenador);

        Button btn_Partidos = findViewById(R.id.btn_Partidos);
        btn_Partidos.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            Intent intent = new Intent(this, SeleccionDeEquipos.class);
            startActivity(intent);
        });

    }
}