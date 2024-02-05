package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class PantallaEntrenamientos extends AppCompatActivity {
    private ArrayList<EntrenamientoConImagen> entrenamientos = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_entrenamientos);

        obtenerEntrenamientos();
        iniciarRecyclerView();
    }

    /**
     * Método que obtiene los entrenamientos de la base de datos.
     */
    private void obtenerEntrenamientos() {
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM entrenamientos", null);

        while (cursor.moveToNext()) {
            String nombre = cursor.getString(1);
            int imagen = cursor.getInt(8);
            entrenamientos.add(new EntrenamientoConImagen(nombre, imagen));
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
}