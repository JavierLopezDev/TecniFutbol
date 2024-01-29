package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
            Intent intent = new Intent(this, LoginFirebase.class);
            startActivity(intent);
        });


    }
}