package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

public class MainActivity extends AppCompatActivity {
    public static SQLiteDatabase database;
    public static String equipoSeleccionadoAEditar = "Prueba10";
    public static int jugadorSeleccionadoAEditarOEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginFirebase.class);
        startActivity(intent);

        // Creación de la base de datos y la tabla entrenamientos
        database = openOrCreateDatabase("TecniFutbol", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS entrenamientos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, tipoEjercicio TEXT, categoriaEdad TEXT, dificultad TEXT, " +
                "duracion TEXT, material TEXT)");
        insertarEntrenamientos();

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        database.execSQL("CREATE TABLE IF NOT EXISTS equipos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, propietario TEXT, nombre TEXT, categoriaPartido TEXT, jugadores INTEGER)");

        database.execSQL("CREATE TABLE IF NOT EXISTS jugadores " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, equipo TEXT, nombre TEXT, dorsal TEXT, posicion TEXT, peso TEXT, altura TEXT, fechaNacimiento DATE, " +
                "piernaHabil TEXT, notas TEXT, disponible BOOLEAN)");

    }

    /**
     * Inserta en la BD los entrenamientos de las diferentes categorías de edad.
     */
    private void insertarEntrenamientos() {
        Cursor cursor = database.rawQuery("SELECT * FROM entrenamientos", null);

        if (cursor.getCount() == 0) {
            InsertarEntrenamientos.insertarEntrenamientosDeMenos8Años();
            InsertarEntrenamientos.insertarEntrenamientosDe8A11Años();
            InsertarEntrenamientos.insertarEntrenamientosDe11A14Años();
            InsertarEntrenamientos.insertarEntrenamientosDe14A18Años();
            InsertarEntrenamientos.insertarEntrenamientosDeMas18Años();
        }
    }
}