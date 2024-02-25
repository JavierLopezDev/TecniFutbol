package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.tecnifutbol.Entrenador.CrearEquipo;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;
import java.util.List;
public class SeleccionDeEquipos extends AppCompatActivity {

    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_de_equipos);

        List<Equipo> listaEquipos = obtenerEquiposDesdeBD();

        adapter = new RecyclerViewAdapter(this, listaEquipos);


        TextView tv_Editar = findViewById(R.id.tv_Editar);
        TextView tv_Partido = findViewById(R.id.tv_Partido);
        tv_Editar.setBackgroundResource(R.drawable.boton);
        tv_Partido.setBackgroundResource(R.drawable.boton);
        ImageButton ib_CrearEquipo = findViewById(R.id.imageButton_NuevoEquipo);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewEquipos);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setBackgroundResource(android.R.color.transparent);
        recyclerView.setAdapter(adapter);

        ib_CrearEquipo.setOnClickListener(v -> {
          //  Intent intent = new Intent(this, CrearEquipo.class);

           Intent intent = new Intent(this, PartidoEnCurso.class);
            startActivity(intent);
        });

        tv_Editar.setOnClickListener(v -> {
            List<Equipo> equiposSeleccionados = adapter.getEquiposSeleccionados();

            if (equiposSeleccionados.size() ==1) {
                Intent intent = new Intent(this, EditarEquipo.class);
                intent.putExtra("equipo1", equiposSeleccionados.get(0));
                startActivity(intent);
            } else {
                // Notificar al usuario que debe seleccionar exactamente 1 equipos
                Toast.makeText(this, "Por favor, seleccione exactamente 1 equipos para el editarlo", Toast.LENGTH_SHORT).show();
            }
        });


        tv_Partido.setOnClickListener(v -> {
            List<Equipo> equiposSeleccionados = adapter.getEquiposSeleccionados();

            if (equiposSeleccionados.size() == 1) {
                Intent intent = new Intent(this, SeleccionTipoPartido.class);
                intent.putExtra("equipo1", equiposSeleccionados.get(0));
                startActivity(intent);
            } else {
                Toast.makeText(this, "Por favor, seleccione exactamente 1 equipos para el partido", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Actualizar la lista de equipos cada vez que la actividad se reanuda
        actualizarListaEquipos();
    }

    private void actualizarListaEquipos() {
        List<Equipo> equipos = obtenerEquiposDesdeBD();
        adapter.actualizarEquipos(equipos);
    }

    private List<Equipo> obtenerEquiposDesdeBD() {
        List<Equipo> equipos = new ArrayList<>();
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM equipos", null);

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String categoria = cursor.getString(cursor.getColumnIndex("categoriaPartido"));
                int jugadores = cursor.getInt(cursor.getColumnIndex("jugadores"));

                Equipo equipo = new Equipo(nombre, categoria, jugadores);
                equipos.add(equipo);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return equipos;
    }
}
