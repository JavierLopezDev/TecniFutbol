package com.dam.tecnifutbol.Jugador.Casa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;

import com.dam.tecnifutbol.Jugador.AdaptadorEntrenamientosJugador;
import com.dam.tecnifutbol.MainActivity;
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

    private void obtenerEntrenamientosCasa() {
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM entrenamientosJugador WHERE lugar = 'CASA'", null);

        while (cursor.moveToNext()) {
            //nombre TEXT, descripcion TEXT, lugar TEXT, repeticiones TEXT, nota TEXT, imagen BLOB, video TEXT
            String nombre = cursor.getString(1);
            String descripcion = cursor.getString(2);
            String lugar = cursor.getString(3);
            String repeticiones = cursor.getString(4);
            String nota = cursor.getString(5);
            int imagen = cursor.getInt(6);
            String video = cursor.getString(7);

            entrenamientosJugador.add(new EntrenamientoJugador(nombre, descripcion, lugar, repeticiones, nota, imagen, video));
        }
    }

    private void iniciarRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEntrenamientosCasa);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new AdaptadorEntrenamientosJugador(entrenamientosJugador);
        recyclerView.setAdapter(myAdapter);
    }
    @Override
    public void onBackPressed() {
    }

}