package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
        TextView tv_cronometro = findViewById(R.id.tv_Cronometro);
        TextView tv_botonMenosTiempo = findViewById(R.id.tv_botonMenosTiempo);
        TextView tv_botonMasTiempo = findViewById(R.id.tv_botonMasTiempo);
        tv_botonMenosTiempo.setBackgroundResource(R.drawable.ico_quitartiempo2);
        tv_botonMasTiempo.setBackgroundResource(R.drawable.ico_aumentartiempo2);
        TextView tv_BotonEmpezar = findViewById(R.id.tv_BotonEmpezar);
        RecyclerView recyclerViewJugadores=findViewById(R.id.recyclerViewJugadores);


    }
}