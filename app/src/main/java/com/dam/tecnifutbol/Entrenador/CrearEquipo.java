package com.dam.tecnifutbol.Entrenador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.dam.tecnifutbol.Entrenador.Partidos.SeleccionDeEquipos;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrearEquipo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_equipo);
        listarCategorias();
        EditText nombre = findViewById(R.id.et_nombreInsertado);
        TextView tv_Error = findViewById(R.id.tv_SinNombre);

        TextView tv_CrearEquipo=findViewById(R.id.tv_CrearEquipo);
        tv_CrearEquipo.setOnClickListener(v -> {
            if (nombre.getText().toString().isEmpty()){
                tv_Error.setText("El nombre es obligatorio");
            }else {
                tv_Error.setText("");
                insertarEquipo(v);
            }

        });



    }
    public void listarCategorias(){
        ArrayAdapter<String> adaptador;
        List<String> lista = new ArrayList<String>();
        lista.add("Futbol Sala");
        lista.add("Futbol 7");
        lista.add("Futbol 8");
        lista.add("Futbol 9");
        lista.add("Futbol 11");

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        Spinner spCategorias = (Spinner) findViewById(R.id.spn_categoriasInsertado);
        spCategorias.setAdapter(adaptador);
        spCategorias.setOnItemSelectedListener(this);

    }
    public void listarCantidadJugadores(int minJugadores, int maxJugadores){
        ArrayAdapter<String> adaptador;
        List<String> lista = new ArrayList<String>();
        for (int i = minJugadores; i < maxJugadores; i++) {
            lista.add(String.valueOf(i));
        }
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        Spinner spCantidadJugadores = (Spinner) findViewById(R.id.spn_cantidadJugadoresInsertado);
        spCantidadJugadores.setAdapter(adaptador);
        spCantidadJugadores.setOnItemSelectedListener(this);
    }
    public void insertarEquipo(View view){
        //Insertar equipo en la base de datos
        EditText nombre = findViewById(R.id.et_nombreInsertado);
        String nombreAInsertar = nombre.getText().toString();
        String propietario = "provisional";
        String categoria = ((Spinner) findViewById(R.id.spn_categoriasInsertado)).getSelectedItem().toString();
        String cantidadJugadores = ((Spinner) findViewById(R.id.spn_cantidadJugadoresInsertado)).getSelectedItem().toString();

        MainActivity.database.execSQL("INSERT INTO equipos (propietario, nombre, categoriaPartido, jugadores) " +
                "VALUES ('"+propietario+"', '"+nombreAInsertar+"', '"+categoria+"', "+cantidadJugadores+")");

        insertarJugadoresEjemplo(nombreAInsertar, Integer.parseInt(cantidadJugadores));
        //Nos movemos a la pantalla de seleccionar equipos
        Intent intent = new Intent(this, SeleccionDeEquipos.class);
        startActivity(intent);

    }

    public void insertarJugadoresEjemplo(String nombreEquipo, int cantidadJugadores){
        String fechaNacimientoEjemploFormateada = "01/01/2000";

        for (int i = 1; i <= cantidadJugadores; i++) {
            MainActivity.database.execSQL("INSERT INTO jugadores (equipo, nombre, dorsal, posicion, peso, altura, fechaNacimiento, piernaHabil, notas, disponible) " +
                    "VALUES ('"+nombreEquipo+"', 'Jugador"+i+"', '"+i+"', 'Portero', '60', '170', '"+fechaNacimientoEjemploFormateada+"', 'Derecha', 'Sin notas', 1)");
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId()==R.id.spn_categoriasInsertado) {
        switch (i){
            case 0:
                listarCantidadJugadores(5, 10);
                break;
            case 1:
                listarCantidadJugadores(7, 14);
                break;
            case 2:
                listarCantidadJugadores(8, 16);
                break;
            case 3:
                listarCantidadJugadores(9, 18);
                break;
            case 4:
                listarCantidadJugadores(11, 24);
                break;
        }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}