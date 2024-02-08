package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;
import java.util.List;

public class ElegirJugadores extends AppCompatActivity {

    List<String> listaTiposDePartidos = new ArrayList<String>();
    int numeroDeJugadores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_jugadores);

        if (MainActivity.tipoPartido.equals("Entrenamiento")){
            paraPartidoEntrenamiento();
        }else if (MainActivity.tipoPartido.equals("VS Equipo")){
            paraPartidoVSEquipo();
        }

    }
    public void paraPartidoEntrenamiento(){
        Spinner spnTipoPartido = findViewById(R.id.spn_tipoPartido);
        consultarJugadores();
        listarTiposDePartidos(numeroDeJugadores);
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaTiposDePartidos);
        spnTipoPartido.setAdapter(adaptador);

        TextView tvTitularBandos = findViewById(R.id.tv_titular_bandos);


    }

    public void paraPartidoVSEquipo(){
        Spinner spnTipoPartido = findViewById(R.id.spn_tipoPartido);
        spnTipoPartido.setEnabled(false);
        spnTipoPartido.setVisibility(View.INVISIBLE);


    }

    public void marcarBandoSeleccionado(ImageView ivBando){
        //Quitar el fondo que tenga la imagen actualmente
        ivBando.setImageResource(R.drawable.boton);
    }
    public void desmarcarBandoSeleccionado(ImageView ivBando){
        //Quitar el fondo que tenga la imagen actualmente
        ivBando.setImageResource(R.drawable.boton);
    }

    public void consultarJugadores(){
        numeroDeJugadores = 0;
        //Se contaran la cantidad de jugadores que hay en el equipo seleccionado
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM jugadores WHERE equipo = '" + MainActivity.equipoSeleccionadoAEditar + "'", null);
        if (cursor.getCount() == 0)
            System.out.println("No hay jugadores en la base de datos");
        else {
            numeroDeJugadores = cursor.getCount();

        }

    }

    public void listarTiposDePartidos(int numeroDeJugadores) {

        listaTiposDePartidos = new ArrayList<String>();
        //Se añade a la lista los tipos de partidos que se pueden jugar pudiendo ser como maximo la mitad de numeroDeJugadores
        //Comprobar si el numero de jugadores es par o impar
        //Si es impar se resta 1 para que sea par
        if (numeroDeJugadores % 2 != 0) {
            numeroDeJugadores = numeroDeJugadores - 1;
        }

        for (int i = 1; i <= numeroDeJugadores / 2; i++) {
            listaTiposDePartidos.add(i + " VS " + (numeroDeJugadores - i));
        }
    }


}