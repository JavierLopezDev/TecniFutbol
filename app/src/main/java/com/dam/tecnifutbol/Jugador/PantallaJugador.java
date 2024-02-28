package com.dam.tecnifutbol.Jugador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.dam.tecnifutbol.Dialogos.DialogMenuHamburguesa;
import com.dam.tecnifutbol.Jugador.Casa.PantallaEntrenamientoCasa;
import com.dam.tecnifutbol.Jugador.Gimnasio.PantallaEntrenamientosGimnasio;
import com.dam.tecnifutbol.R;

public class PantallaJugador extends AppCompatActivity {

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

        LinearLayout casa = findViewById(R.id.ly_casa);
        LinearLayout gym = findViewById(R.id.ly_gym);

        casa.setOnClickListener(v -> {
            Intent intent = new Intent(this, PantallaEntrenamientoCasa.class);
            startActivity(intent);
        });

        gym.setOnClickListener(v -> {
            Intent intent = new Intent(this, PantallaEntrenamientosGimnasio.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
    }
}