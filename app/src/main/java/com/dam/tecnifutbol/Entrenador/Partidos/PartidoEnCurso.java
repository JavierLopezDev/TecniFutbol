package com.dam.tecnifutbol.Entrenador.Partidos;

import static com.dam.tecnifutbol.MainActivity.jugadoresTitularesSeleccionados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dam.tecnifutbol.Adaptadores.ListaJugadoresAdapter;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

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
    private TextView tv_botonMenosGolesLocal;
    private TextView tv_botonMenosGolesVisitante;
    private TextView tv_botonMasGolesLocal;
    private TextView tv_botonMasGolesVisitante;
    private RecyclerView recyclerViewJugadores;
    private CountDownTimer contador;
    private boolean cuentaAtrasCorriendo = false;
    private long tiempoRestanteEnMillis = 0;
    private int golesLocal = 0;
    private int golesVisitante = 0;
    private JugadorAdapter jugadorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_en_curso);


        imageViewImagenEquipo1 = findViewById(R.id.imageview_equipo1);
        tv_NombreEquipo1 = findViewById(R.id.tv_NombreEquipo1);
        tv_NombreEquipo2 = findViewById(R.id.tv_NombreEquipo2);
        imageViewImagenEquipo2 = findViewById(R.id.imageview_equipo2);
        tv_Marcador = findViewById(R.id.tv_Marcador);
        tv_cronometro = findViewById(R.id.tv_Cronometro);
        tv_botonMenosTiempo = findViewById(R.id.tv_botonMenosTiempo);
        tv_botonMasTiempo = findViewById(R.id.tv_botonMasTiempo);

        tv_botonMenosGolesLocal = findViewById(R.id.tv_botonMenosGolesLocal);
        tv_botonMenosGolesLocal.setBackgroundResource(R.drawable.flechabajo);
        tv_botonMenosGolesVisitante = findViewById(R.id.tv_botonMenosGolesVisitante);
        tv_botonMenosGolesVisitante.setBackgroundResource(R.drawable.flechabajo);
        tv_botonMasGolesLocal = findViewById(R.id.tv_botonMasGolesLocal);
        tv_botonMasGolesLocal.setBackgroundResource(R.drawable.flechaarriba);
        tv_botonMasGolesVisitante = findViewById(R.id.tv_botonMasGolesVisitante);
        tv_botonMasGolesVisitante.setBackgroundResource(R.drawable.flechaarriba);

        tv_BotonEmpezar = findViewById(R.id.tv_BotonEmpezar);
        recyclerViewJugadores = findViewById(R.id.recyclerViewJugadores);
        tv_botonMenosTiempo.setBackgroundResource(R.drawable.ico_quitartiempo2);
        tv_botonMasTiempo.setBackgroundResource(R.drawable.ico_aumentartiempo2);
        recyclerViewJugadores = findViewById(R.id.recyclerViewJugadores);
        recyclerViewJugadores.setLayoutManager(new LinearLayoutManager(this));


        List<JugadorEstadisticas> estadisticasJugadores = convertirAJugadorEstadisticas(jugadoresTitularesSeleccionados);
        jugadorAdapter = new JugadorAdapter(estadisticasJugadores, MainActivity.database);
        recyclerViewJugadores.setAdapter(jugadorAdapter);


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
        tv_botonMasGolesLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golesLocal = golesLocal + 1;
                golesVisitante = golesVisitante;
                String marcador = String.format("%2d:%2d", golesLocal, golesVisitante);
                tv_Marcador.setText(marcador);
            }
        });
        tv_botonMasGolesVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golesLocal = golesLocal;
                golesVisitante = golesVisitante + 1;
                String marcador = String.format("%2d:%2d", golesLocal, golesVisitante);
                tv_Marcador.setText(marcador);
            }
        });
        tv_botonMenosGolesLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (golesLocal > 0) {
                    golesLocal = golesLocal - 1;
                    golesVisitante = golesVisitante;
                    String marcador = String.format("%2d:%2d", golesLocal, golesVisitante);
                    tv_Marcador.setText(marcador);
                }
            }
        });
        tv_botonMenosGolesVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (golesVisitante > 0) {
                    golesLocal = golesLocal;
                    golesVisitante = golesVisitante - 1;
                    String marcador = String.format("%2d:%2d", golesLocal, golesVisitante);
                    tv_Marcador.setText(marcador);
                }
            }
        });
    }

    private List<JugadorEstadisticas> convertirAJugadorEstadisticas(List<Jugador> jugadores) {
        List<JugadorEstadisticas> estadisticasJugadores = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            JugadorEstadisticas jugadorEstadisticas = new JugadorEstadisticas(jugador.getNombre(), jugador.getPosicion());
            estadisticasJugadores.add(jugadorEstadisticas);
        }
        return estadisticasJugadores;
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

    private void actualizarMarcador() {

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
