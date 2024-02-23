package com.dam.tecnifutbol.Jugador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

public class DetallesEntrenamientoJugador extends AppCompatActivity {

    TextView titulo;
    VideoView video;
    TextView repeticiones;
    TextView nota;
    TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_entrenamiento_jugador);

        titulo = findViewById(R.id.tituloEntrJugDetalles);
        video = findViewById(R.id.videoEntrJugDetalles);
        repeticiones = findViewById(R.id.repeticionesEntrJugDetalles);
        nota = findViewById(R.id.notaEntrJugDetalles);
        descripcion = findViewById(R.id.descripcionEntrJugDetalles);

        cargarDatosEntrenamientoJugador();

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            finish();
        });
    }

    private void cargarDatosEntrenamientoJugador() {
        titulo.setText(MainActivity.nombreEntrJug);
        video.setVideoPath(MainActivity.videoEntrJug);
        video.setOnPreparedListener(mp -> mp.setLooping(true));
        video.start();
        repeticiones.setText(MainActivity.repeticionesEntrJug);
        if (MainActivity.notaEntrJug.length() == 0) {
            nota.setText("");
        } else {
            nota.setText("Nota: " + MainActivity.notaEntrJug);
        }
        descripcion.setText(MainActivity.descripcionEntrJug);
    }
}