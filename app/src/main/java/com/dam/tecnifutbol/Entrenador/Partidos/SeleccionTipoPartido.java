package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

public class SeleccionTipoPartido extends AppCompatActivity {

    TextView tv_pEntrenamiento, tv_pVsEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_tipo_partido);

        tv_pEntrenamiento = findViewById(R.id.tv_pEntrenamiento);
        tv_pVsEquipo = findViewById(R.id.tv_pVsEquipo);

        tv_pEntrenamiento.setOnClickListener(view -> {
            /*Intent intent = new Intent(SeleccionTipoPartido.this, {NombreClase}.class);
            startActivity(intent);*/
        });

        tv_pVsEquipo.setOnClickListener(view -> {
            /*Intent intent = new Intent(SeleccionTipoPartido.this, {NombreClase}.class);
            startActivity(intent);*/
        });

    }
}