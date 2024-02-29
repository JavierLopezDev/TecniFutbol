package com.dam.tecnifutbol.Entrenador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.tecnifutbol.Dialogos.DialogoMenuHamburguesa;
import com.dam.tecnifutbol.Entrenador.Entrenamientos.PantallaEntrenamientos;
import com.dam.tecnifutbol.Entrenador.Partidos.SeleccionDeEquipos;
import com.dam.tecnifutbol.R;

public class PantallaEntrenador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenador);

        LinearLayout ly_Entrenamientos=findViewById(R.id.ly_entrenamientos);
        LinearLayout ly_Partidos=findViewById(R.id.ly_partidos);
        TextView tv_Partidos=findViewById(R.id.tv_Partidos);
        TextView tvTituloEntrenador=findViewById(R.id.tv_TituloEntrenador);


        ly_Entrenamientos.setOnClickListener(v -> {
            Intent intent = new Intent(this, PantallaEntrenamientos.class);
            startActivity(intent);
        });
        ly_Partidos.setOnClickListener(v -> {

            Intent intent = new Intent(this, SeleccionDeEquipos.class);
            startActivity(intent);
        });
        //Cuando seleccione btn_Partidos me llevara a la actividad de seleccionDeEquipos

        ImageButton menuHaburguesa = findViewById(R.id.burguer_menu);
        menuHaburguesa.setOnClickListener(v -> {
            DialogoMenuHamburguesa dialogoMenuHamburguesa = new DialogoMenuHamburguesa();
            dialogoMenuHamburguesa.show(getSupportFragmentManager(), "Menu");
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