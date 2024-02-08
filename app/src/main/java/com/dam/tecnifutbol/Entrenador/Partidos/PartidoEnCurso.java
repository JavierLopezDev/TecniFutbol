package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

public class PartidoEnCurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_en_curso);

        ImageView imageViewImagenEquipo1=findViewById(R.id.imageview_equipo1);
        TextView tv_NombreEquipo1 = findViewById(R.id.tv_NombreEquipo1);
        TextView tv_CategoriaEquipo1 = findViewById(R.id.tv_CategoriaEquipo1);
        TextView tv_NombreEquipo2 = findViewById(R.id.tv_NombreEquipo2);
        TextView tv_CategoriaEquipo2 = findViewById(R.id.tv_CategoriaEquipo1);
        ImageView imageViewImagenEquipo2=findViewById(R.id.imageview_equipo2);

        TextView tv_Marcador = findViewById(R.id.tv_Marcador);

        //tv_Editar.setBackgroundResource(R.drawable.boton);
        //tv_Partido.setBackgroundResource(R.drawable.boton);
        //ImageButton ib_CrearEquipo = findViewById(R.id.imageButton_NuevoEquipo);
    }
}