package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;

import com.dam.tecnifutbol.DialogMenuHamburguesa;
import com.dam.tecnifutbol.Entrenador.PantallaEntrenador;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Entrenamiento;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class PantallaEntrenamientos extends AppCompatActivity {
    private ArrayList<Entrenamiento> entrenamientos = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenamientos);

        obtenerEntrenamientos();
        iniciarRecyclerView();

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            finish();
        });
    }

    /**
     * Método que obtiene los entrenamientos de la base de datos.
     */
    private void obtenerEntrenamientos() {
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM entrenamientos", null);

        while (cursor.moveToNext()) {
            String nombre = cursor.getString(1);
            String descripcion = cursor.getString(2);
            String tipoEjercicio = cursor.getString(3);
            String categoriaEdad = cursor.getString(4);
            String dificultad = cursor.getString(5);
            String duracion = cursor.getString(6);
            String material = cursor.getString(7);
            int imagen = cursor.getInt(8);
            String video = cursor.getString(9);

            entrenamientos.add(new Entrenamiento(nombre, descripcion, categoriaEdad, dificultad, duracion, material, tipoEjercicio, imagen, video));
        }

        cursor.close();
    }

    /**
     * Método que inicia el RecyclerView para mostrar los entrenamientos.
     */
    private void iniciarRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewEntrenamientos);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new AdaptadorEntrenamientos(entrenamientos);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed() {
    }
}