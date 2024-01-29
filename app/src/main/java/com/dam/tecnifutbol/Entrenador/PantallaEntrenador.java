package com.dam.tecnifutbol.Entrenador;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.tecnifutbol.Entrenador.Partidos.SeleccionDeEquipos;
import com.dam.tecnifutbol.LoginFirebase;
import com.dam.tecnifutbol.R;

public class PantallaEntrenador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenador);

        //Cuando seleccione btn_Partidos me llevara a la actividad de seleccionDeEquipos
        /*Intent intent = new Intent(this, SeleccionDeEquipos.class);
        startActivity(intent);*/

    }
}