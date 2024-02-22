package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.dam.tecnifutbol.DialogMenuHamburguesa;
import com.dam.tecnifutbol.R;

public class SeleccionTipoPartido extends AppCompatActivity {

    LinearLayout ly_pEntrenamiento, ly_pVsEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_tipo_partido);

        ly_pEntrenamiento = findViewById(R.id.ly_pEntrenamiento);
        ly_pVsEquipo = findViewById(R.id.ly_pVsEquipo);

        ly_pEntrenamiento.setOnClickListener(view -> {
            /*Intent intent = new Intent(SeleccionTipoPartido.this, {NombreClase}.class);
            startActivity(intent);*/
        });

        ly_pVsEquipo.setOnClickListener(view -> {
            /*Intent intent = new Intent(SeleccionTipoPartido.this, {NombreClase}.class);
            startActivity(intent);*/
        });

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