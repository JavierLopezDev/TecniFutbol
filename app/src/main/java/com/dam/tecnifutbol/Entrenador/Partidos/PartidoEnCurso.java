package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dam.tecnifutbol.R;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class PartidoEnCurso extends AppCompatActivity {
    private ImageView imageViewImagenEquipo1;
    private TextView tv_NombreEquipo1;
    private TextView tv_CategoriaEquipo1;
    private TextView tv_NombreEquipo2;
    private TextView tv_CategoriaEquipo2;
    private ImageView imageViewImagenEquipo2;
    private TextView tv_Marcador;
    private TextView tv_cronometro;
    private TextView tv_botonMenosTiempo;
    private TextView tv_botonMasTiempo;
    private TextView tv_BotonEmpezar;
    private RecyclerView recyclerViewJugadores;
    private CountDownTimer contador;
    private boolean cuentaAtrasCorriendo = false;
    private long tiempoRestanteEnMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_en_curso);

        imageViewImagenEquipo1 = findViewById(R.id.imageview_equipo1);
        tv_NombreEquipo1 = findViewById(R.id.tv_NombreEquipo1);
        tv_CategoriaEquipo1 = findViewById(R.id.tv_CategoriaEquipo1);
        tv_NombreEquipo2 = findViewById(R.id.tv_NombreEquipo2);
        tv_CategoriaEquipo2 = findViewById(R.id.tv_CategoriaEquipo2);
        imageViewImagenEquipo2 = findViewById(R.id.imageview_equipo2);
        tv_Marcador = findViewById(R.id.tv_Marcador);
        tv_cronometro = findViewById(R.id.tv_Cronometro);
        tv_botonMenosTiempo = findViewById(R.id.tv_botonMenosTiempo);
        tv_botonMasTiempo = findViewById(R.id.tv_botonMasTiempo);
        tv_BotonEmpezar = findViewById(R.id.tv_BotonEmpezar);
        recyclerViewJugadores = findViewById(R.id.recyclerViewJugadores);
        tv_botonMenosTiempo.setBackgroundResource(R.drawable.ico_quitartiempo2);
        tv_botonMasTiempo.setBackgroundResource(R.drawable.ico_aumentartiempo2);
        recyclerViewJugadores = findViewById(R.id.recyclerViewJugadores);
        recyclerViewJugadores.setLayoutManager(new LinearLayoutManager(this));


        tv_BotonEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cuentaAtrasCorriendo) {
                    empezarCronometro();
                } else {
                    pararCronometro();
                }
            }
        });

        tv_botonMasTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarTiempo(120000); // Aumentar en 2 minutos (120,000 ms)
            }
        });

        tv_botonMenosTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirTiempo(60000); // Disminuir en 1 minuto (60,000 ms)
            }
        });
    }

    private void empezarCronometro() {
        contador = new CountDownTimer(tiempoRestanteEnMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoRestanteEnMillis = millisUntilFinished;
                actualizarCronometro();
            }

            @Override
            public void onFinish() {
                cuentaAtrasCorriendo = false;
                tv_BotonEmpezar.setText("Empezar");
                tv_botonMasTiempo.setEnabled(true);
                tv_botonMenosTiempo.setEnabled(true);
                mostrarDialogoPartidoFinalizado();
            }
        }.start();
        tv_botonMasTiempo.setEnabled(false);
        tv_botonMenosTiempo.setEnabled(false);
        cuentaAtrasCorriendo = true;
        tv_BotonEmpezar.setText("Parar");
    }

    private void pararCronometro() {
        contador.cancel();
        cuentaAtrasCorriendo = false;
        tv_BotonEmpezar.setText("Empezar");
        tv_botonMasTiempo.setEnabled(true);
        tv_botonMenosTiempo.setEnabled(true);
    }

    private void actualizarCronometro() {
        int minutos = (int) (tiempoRestanteEnMillis / 1000) / 60;
        int segundos = (int) (tiempoRestanteEnMillis / 1000) % 60;
        String tiempoRestante = String.format("%02d:%02d", minutos, segundos);
        tv_cronometro.setText(tiempoRestante);
    }

    private void aumentarTiempo(long tiempo) {
        tiempoRestanteEnMillis += tiempo;
        actualizarCronometro();
    }

    private void disminuirTiempo(long tiempo) {
        tiempoRestanteEnMillis -= tiempo;
        if (tiempoRestanteEnMillis < 0) {
            tiempoRestanteEnMillis = 0;
        }
        actualizarCronometro();
    }
    private void mostrarDialogoPartidoFinalizado() {
        String marcador = tv_Marcador.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Partido Finalizado!")
                .setMessage("El partido ha finalizado. Marcador final: " + marcador)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
