package com.dam.tecnifutbol.Jugador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.dam.tecnifutbol.DialogMenuHamburguesa;
import com.dam.tecnifutbol.R;

public class PantallaSeleccionEntrenamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_seleccion_entrenamiento);

        ImageButton menuHaburguesa = findViewById(R.id.burguer_menu);
        menuHaburguesa.setOnClickListener(v -> {
            DialogMenuHamburguesa dialogMenuHamburguesa = new DialogMenuHamburguesa();
            dialogMenuHamburguesa.show(getSupportFragmentManager(), "Menu");
        });

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    public void onBackPressed() {
    }
}