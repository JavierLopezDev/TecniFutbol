package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dam.tecnifutbol.Adaptadores.ListaJugadoresAdapter;
import com.dam.tecnifutbol.Dialogos.DialogoMenuHamburguesa;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class EditarEquipo extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Jugador> listaJugadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipo);
        System.out.println("Equipo seleccionado a editar: " + MainActivity.equipoSeleccionadoAEditar);
        listaJugadores = new ArrayList<>();
        RecyclerView recyclerViewJugadores = findViewById(R.id.rv_jugadores);
        recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3));

        consultarJugadores(MainActivity.equipoSeleccionadoAEditar);

        ListaJugadoresAdapter adapter = new ListaJugadoresAdapter(listaJugadores);
        recyclerViewJugadores.setAdapter(adapter);

        TextView tv_EditarJugador = findViewById(R.id.tv_editarJugador);
        TextView tv_EliminarJugador = findViewById(R.id.tv_eliminarJugador);

        tv_EliminarJugador.setOnClickListener(v -> {
            eliminarJugador();
            listaJugadores = new ArrayList<>();
            consultarJugadores(MainActivity.equipoSeleccionadoAEditar);
            ListaJugadoresAdapter adapter2 = new ListaJugadoresAdapter(listaJugadores);
            recyclerViewJugadores.setAdapter(adapter2);
        });
        tv_EditarJugador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de editar jugador
            MainActivity.clicadoEditar = true;
            Intent intent = new Intent(this, EditarOCrearJugador.class);
            startActivity(intent);
        });
        ImageButton ibCrearJugador = findViewById(R.id.imageButton_NuevoJugador);
        ibCrearJugador.setOnClickListener(v -> {
            //Nos movemos a la pantalla de crear jugador
            MainActivity.jugadorSeleccionadoAEditar = null;
            MainActivity.clicadoEditar = false;
            Intent intent = new Intent(this, EditarOCrearJugador.class);
            startActivity(intent);
        });

        ImageButton menuHaburguesa = findViewById(R.id.burguer_menu);
        menuHaburguesa.setOnClickListener(v -> {
            DialogoMenuHamburguesa dialogoMenuHamburguesa = new DialogoMenuHamburguesa();
            dialogoMenuHamburguesa.show(getSupportFragmentManager(), "Menu");
        });

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            MainActivity.jugadorSeleccionadoAEditar = null;
            finish();
        });
    }

    public void consultarJugadores(String equipoABuscar) {
        SQLiteDatabase database = MainActivity.database;
        Cursor cursor = database.rawQuery("SELECT * FROM jugadores WHERE equipo = '" + equipoABuscar + "'", null);
        if (cursor.getCount() == 0)
            System.out.println("No hay jugadores en la base de datos");
        else {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String equipo = cursor.getString(1);
                String nombre = cursor.getString(2);
                String dorsal = cursor.getString(3);
                String posicion = cursor.getString(4);
                String peso = cursor.getString(5);
                String altura = cursor.getString(6);
                String fechaNacimiento = cursor.getString(7);
                String piernaHabil = cursor.getString(8);
                String notas = cursor.getString(9);
                int disponible = cursor.getInt(10);
                boolean disponibleBoolean = false;
                if (disponible == 1) {
                    disponibleBoolean = true;
                }


                Jugador jugador = new Jugador(id, equipo, nombre, dorsal, posicion, peso, altura, fechaNacimiento, piernaHabil, notas, disponibleBoolean);
                listaJugadores.add(jugador);
            }
            //Odernar la lista de menor a mayor por su dorsal
            listaJugadores.sort((o1, o2) -> {
                int dorsal1 = Integer.parseInt(o1.getDorsal());
                int dorsal2 = Integer.parseInt(o2.getDorsal());
                return Integer.compare(dorsal1, dorsal2);
            });
        }
    }

    public void eliminarJugador() {
        MainActivity.database.execSQL("DELETE FROM jugadores WHERE id = " + MainActivity.jugadorSeleccionadoAEditarOEliminar);
    }

    @Override
    public void onClick(View view) {
        if (view.getClass().getSimpleName().equals("LinearLayout")) {
            LinearLayout linearLayout = (LinearLayout) view;
            if (linearLayout.getBackground().getConstantState() == getResources().getDrawable(R.drawable.botonseleccionado).getConstantState())
                linearLayout.setBackgroundResource(R.drawable.boton);
            else
                linearLayout.setBackgroundResource(R.drawable.botonseleccionado);
        }
    }

    @Override
    public void onBackPressed() {
    }
}