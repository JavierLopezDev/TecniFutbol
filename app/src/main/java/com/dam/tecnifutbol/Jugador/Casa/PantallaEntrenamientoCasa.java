package com.dam.tecnifutbol.Jugador.Casa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.dam.tecnifutbol.Jugador.AdaptadorEntrenamientosJugador;
import com.dam.tecnifutbol.Modelo.EntrenamientoJugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class PantallaEntrenamientoCasa extends AppCompatActivity {

    private ArrayList<EntrenamientoJugador> entrenamientosJugador = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenamiento_casa);

        obtenerEntrenamientosCasa();
        iniciarRecyclerView();

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            finish();
        });
    }

    private void iniciarRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEntrenamientos);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new AdaptadorEntrenamientosJugador(entrenamientosJugador);
        recyclerView.setAdapter(myAdapter);
    }

    private void obtenerEntrenamientosCasa() {

    }
}