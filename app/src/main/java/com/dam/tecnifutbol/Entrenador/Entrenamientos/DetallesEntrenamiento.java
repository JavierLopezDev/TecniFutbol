package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

public class DetallesEntrenamiento extends AppCompatActivity {
    VideoView videoView;
    TextView nombreEntrenamiento;
    TextView descripcionEntrenamiento;
    TextView edadesEntrenamiento;
    TextView dificultadEntrenamiento;
    TextView duracionEntrenamiento;
    TextView materialEntrenamiento;
    TextView tipoEntrenamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_entrenamiento);

        videoView = findViewById(R.id.videoEntrenamiento);
        nombreEntrenamiento = findViewById(R.id.tituloEntrenamiento);
        descripcionEntrenamiento = findViewById(R.id.descripcionEntrenamiento);
        edadesEntrenamiento = findViewById(R.id.categoriaEntrenamiento);
        dificultadEntrenamiento = findViewById(R.id.dificultadEntrenamiento);
        duracionEntrenamiento = findViewById(R.id.duracionEntrenamiento);
        materialEntrenamiento = findViewById(R.id.materialesEntrenamiento);
        tipoEntrenamiento = findViewById(R.id.tipoEntrenamiento);

        cargarDatosEntrenamiento();
    }

    private void cargarDatosEntrenamiento() {
        nombreEntrenamiento.setText(MainActivity.nombreEntrenamiento);
        descripcionEntrenamiento.setText(MainActivity.descripcionEntrenamiento);
        edadesEntrenamiento.setText(MainActivity.edadesEntrenamiento);
        dificultadEntrenamiento.setText(MainActivity.dificultadEntrenamiento);
        duracionEntrenamiento.setText(MainActivity.duracionEntrenamiento);
        materialEntrenamiento.setText(MainActivity.materialesEntrenamiento);
        tipoEntrenamiento.setText(MainActivity.tipoEntrenamiento);
        videoView.setVideoPath(MainActivity.videoEntrenamiento);
    }
}