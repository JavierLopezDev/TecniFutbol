package com.dam.tecnifutbol.Jugador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.dam.tecnifutbol.Entrenador.Entrenamientos.PantallaEntrenamientos;
import com.dam.tecnifutbol.Jugador.Casa.PantallaEntrenamientoCasa;
import com.dam.tecnifutbol.Jugador.Gimnasio.PantallaEntrenamientosGimnasio;
import com.dam.tecnifutbol.R;

public class PantallaSeleccionEntrenamiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_seleccion_entrenamiento);

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