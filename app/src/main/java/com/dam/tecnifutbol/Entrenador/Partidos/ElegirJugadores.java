package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;
import java.util.List;

public class ElegirJugadores extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    RecyclerView recyclerViewJugadores;
    ArrayList<Jugador> listaJugadores;
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
        spnTipoPartido.setOnItemSelectedListener(this);


        TextView tvTitularBandos = findViewById(R.id.tv_titular_bandos);
        listaJugadores = new ArrayList<>();
        recyclerViewJugadores = findViewById(R.id.rv_jugadores_partido);
        recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));

        consultarJugadores(MainActivity.equipoSeleccionadoAEditar);




        ImageView imageViewLadoIzquierdo = findViewById(R.id.imageView_lado_izaquierdo);
        ImageView imageViewLadoDerecho = findViewById(R.id.imageView_lado_derecho);

        tvTitularBandos.setText("Equipo 1");
        imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul_seleccionado);
        MainActivity.bandoSeleccionadoEnElegirJugadores = "Equipo 1";


        imageViewLadoIzquierdo.setOnClickListener(v -> {
            imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul_seleccionado);
            imageViewLadoDerecho.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_rojo);
            tvTitularBandos.setText("Equipo 1");
            MainActivity.bandoSeleccionadoEnElegirJugadores = "Equipo 1";
            /*listaJugadores = new ArrayList<>();
            consultarJugadores(MainActivity.equipoSeleccionadoAEditar);
            recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));*/
        });
        imageViewLadoDerecho.setOnClickListener(v -> {
            imageViewLadoDerecho.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_rojo_seleccionado);
            imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul);
            tvTitularBandos.setText("Equipo 2");
            MainActivity.bandoSeleccionadoEnElegirJugadores = "Equipo 2";
            /*listaJugadores = new ArrayList<>();
            consultarJugadores(MainActivity.equipoSeleccionadoAEditar);
            recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));*/
        });


    }

    public void paraPartidoVSEquipo(){
        Spinner spnTipoPartido = findViewById(R.id.spn_tipoPartido);
        spnTipoPartido.setEnabled(false);
        spnTipoPartido.setVisibility(View.INVISIBLE);
        listaJugadores = new ArrayList<>();
        RecyclerView recyclerViewJugadores = findViewById(R.id.rv_jugadores_partido);
        recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));

        consultarJugadores(MainActivity.equipoSeleccionadoAEditar);

        TextView tvTitularBandos = findViewById(R.id.tv_titular_bandos);
        listaJugadores = new ArrayList<>();
        recyclerViewJugadores = findViewById(R.id.rv_jugadores_partido);
        recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));

        consultarJugadores(MainActivity.equipoSeleccionadoAEditar);

        consultarMaximoJugadores();
        ListaElegirJugadoresAdapter adapter = new ListaElegirJugadoresAdapter(listaJugadores, MainActivity.maximoJugadoresTitulares);
        recyclerViewJugadores.setAdapter(adapter);



        ImageView imageViewLadoIzquierdo = findViewById(R.id.imageView_lado_izaquierdo);
        ImageView imageViewLadoDerecho = findViewById(R.id.imageView_lado_derecho);

        tvTitularBandos.setText("Titulares");
        imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul_seleccionado);
        MainActivity.bandoSeleccionadoEnElegirJugadores = "Titulares";


        imageViewLadoIzquierdo.setOnClickListener(v -> {
            imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul_seleccionado);
            imageViewLadoDerecho.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_rojo);
            tvTitularBandos.setText("Titulares");
            MainActivity.bandoSeleccionadoEnElegirJugadores = "Titulares";
            /*listaJugadores = new ArrayList<>();
            consultarJugadores(MainActivity.equipoSeleccionadoAEditar);
            recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));*/
        });
        imageViewLadoDerecho.setOnClickListener(v -> {
            imageViewLadoDerecho.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_rojo_seleccionado);
            imageViewLadoIzquierdo.setImageResource(R.drawable.jugador_de_futbol_intentando_patear_la_pelota_azul);
            tvTitularBandos.setText("Suplentes");
            MainActivity.bandoSeleccionadoEnElegirJugadores = "Suplentes";
            /*listaJugadores = new ArrayList<>();
            consultarJugadores(MainActivity.equipoSeleccionadoAEditar);
            recyclerViewJugadores.setLayoutManager(new GridLayoutManager(this, 3 ));*/
        });
    }


    public int comprobarTipoPartidoEntrenamientoSeleccionado(){
        Spinner spnTipoPartido = findViewById(R.id.spn_tipoPartido);
        String tipoPartidoSeleccionado = spnTipoPartido.getSelectedItem().toString();
        String[] partes = tipoPartidoSeleccionado.split(" ");
        int numeroDeJugadoresPorEquipo = Integer.parseInt(partes[0]);
        System.out.println("Numero de jugadores por equipo: " + numeroDeJugadoresPorEquipo);
        return numeroDeJugadoresPorEquipo;
    }


    public void consultarMaximoJugadores(){
        //Se consultará el tipo de equipo seleccionado para saber cuantos jugadores puede tener
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM equipos WHERE nombre = '" + MainActivity.equipoSeleccionadoAEditar + "'", null);
        if (cursor.getCount() == 0)
            System.out.println("No hay equipos en la base de datos");
        else {
            while (cursor.moveToNext()) {
                //Se busca la cateforia de partido del equipo seleccionado
                String categoriaPartido = cursor.getString(3);
                if (categoriaPartido.equals("Futbol Sala"))
                    MainActivity.maximoJugadoresTitulares = 5;
                else if (categoriaPartido.equals("Futbol 11"))
                    MainActivity.maximoJugadoresTitulares = 11;
                else if (categoriaPartido.equals("Futbol 7"))
                    MainActivity.maximoJugadoresTitulares = 7;
                else if (categoriaPartido.equals("Futbol 8"))
                    MainActivity.maximoJugadoresTitulares = 8;
                else if (categoriaPartido.equals("Futbol 9"))
                    MainActivity.maximoJugadoresTitulares = 9;
                System.out.println("Maximo de jugadores titulares: " + MainActivity.maximoJugadoresTitulares);
            }
        }

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

    public void listarTiposDePartidos(int numeroDeJugadores) {

        listaTiposDePartidos = new ArrayList<String>();
        //Se añade a la lista los tipos de partidos que se pueden jugar pudiendo ser como maximo la mitad de numeroDeJugadores
        //Comprobar si el numero de jugadores es par o impar
        //Si es impar se resta 1 para que sea par
        if (numeroDeJugadores % 2 != 0) {
            numeroDeJugadores = numeroDeJugadores - 1;
        }

        for (int i = 1; i <= numeroDeJugadores / 2; i++) {
            //Se añade a la lista los tipos de partidos que se pueden jugar pudiendo ser como maximo la mitad de numeroDeJugadores, y ambos equipos deben tener el mismo numero de jugadores
            listaTiposDePartidos.add( i + " vs " + i);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//Se comprueba el spinner de tipo de Partido de entrenamiento
        if (adapterView.getId() == R.id.spn_tipoPartido){
            comprobarTipoPartidoEntrenamientoSeleccionado();
            RecyclerView recyclerViewJugadores = findViewById(R.id.rv_jugadores_partido);
            ListaElegirJugadoresAdapter adapter = new ListaElegirJugadoresAdapter(listaJugadores, comprobarTipoPartidoEntrenamientoSeleccionado());
            recyclerViewJugadores.setAdapter(adapter);
            MainActivity.jugadoresSuplentesSeleccionados = new ArrayList<>();
            MainActivity.jugadoresTitularesSeleccionados = new ArrayList<>();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}