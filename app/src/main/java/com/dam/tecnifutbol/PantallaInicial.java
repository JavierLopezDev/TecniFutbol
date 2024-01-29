package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.dam.tecnifutbol.Entrenador.SeleccionDeEquipos;
import com.dam.tecnifutbol.R;

public class PantallaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_inicial);
        TextView etEntrenador = findViewById(R.id.et_entrenador);
        TextView etJugador = findViewById(R.id.et_jugador);

        //Configuración botones
        etEntrenador.setTextSize(30);
        etJugador.setTextSize(30);
        etEntrenador.setTextColor(getResources().getColor(R.color.white));
        etJugador.setTextColor(getResources().getColor(R.color.white));
        etEntrenador.setBackgroundResource(R.drawable.boton);
        etJugador.setBackgroundResource(R.drawable.boton);

        etEntrenador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de login
            // setContentView(R.layout.activity_seleccion_de_equipos);
            //  Intent intent = new Intent(this, SeleccionDeEquipos.class);
            // startActivity(intent);
        });


    }
}