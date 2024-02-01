package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.dam.tecnifutbol.R;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = openOrCreateDatabase("TecniFutbol", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS entrenamientos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, categoria TEXT, duracion TEXT, " +
                "descripcion TEXT, repeticiones INTEGER, material TEXT)");
    }
}