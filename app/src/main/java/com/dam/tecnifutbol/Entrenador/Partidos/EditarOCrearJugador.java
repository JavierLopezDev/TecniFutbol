package com.dam.tecnifutbol.Entrenador.Partidos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.dam.tecnifutbol.Dialogos.DialogMenuHamburguesa;
import com.dam.tecnifutbol.Dialogos.DialogoFecha;
import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;
import java.util.List;

public class EditarOCrearJugador extends AppCompatActivity {

    DialogoFecha dialogoFecha = new DialogoFecha();
    ArrayList<String> numerosDisponibles = new ArrayList<>();
    List<String> listaPosiciones = new ArrayList<String>();
    List<String> listaPiernasHabiles = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_ocrear_jugador);

        EditText etNombreJugador = findViewById(R.id.et_nombreJugadorInsertado);
        Spinner spnNumeroJugador = findViewById(R.id.spn_dorsalJugadorInsertado);
        Spinner spnPosicionJugador = findViewById(R.id.spn_posicionJugadorInsertado);
        EditText etPesoJugador = findViewById(R.id.et_pesoJugadorInsertado);
        EditText etAlturaJugador = findViewById(R.id.et_alturaJugadorInsertado);
        EditText etFechaNacJugador = findViewById(R.id.et_fechaNacJugadorInsertado);

        Spinner spnPiernaHabilJugador = findViewById(R.id.spn_piernaHabilJugadorInsertado);
        EditText etNotasJugador = findViewById(R.id.et_notasJugadorInsertado);
        Switch swtDisponible = findViewById(R.id.swt_jugadorDisponible);
        TextView tvAceptar = findViewById(R.id.tv_aceptarCambiosOInsertar);
        etFechaNacJugador.setOnClickListener(v -> clickFecha());


        if (MainActivity.jugadorSeleccionadoAEditar != null) {
            // Si el jugador no es nulo, se trata de una edición
            // Se rellenan los campos con los datos del jugador
            etNombreJugador.setText(MainActivity.jugadorSeleccionadoAEditar.getNombre());
            etPesoJugador.setText(MainActivity.jugadorSeleccionadoAEditar.getPeso());
            etAlturaJugador.setText(MainActivity.jugadorSeleccionadoAEditar.getAltura());

            // Se rellena el spinner con los números disponibles
            consultarNumerosSpinner();
            ArrayAdapter<String> adapterNumeros = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numerosDisponibles);
            spnNumeroJugador.setAdapter(adapterNumeros);
            spnNumeroJugador.setSelection(adapterNumeros.getPosition(MainActivity.jugadorSeleccionadoAEditar.getDorsal()));

            // Se rellena el spinner con las posiciones
            listarPosiciones();
            ArrayAdapter<String> adapterPosiciones = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPosiciones);
            spnPosicionJugador.setAdapter(adapterPosiciones);
            spnPosicionJugador.setSelection(adapterPosiciones.getPosition(MainActivity.jugadorSeleccionadoAEditar.getPosicion()));

            // Se rellena el spinner con las piernas habiles
            listarPiernasHabiles();
            ArrayAdapter<String> adapterPiernasHabiles = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPiernasHabiles);
            spnPiernaHabilJugador.setAdapter(adapterPiernasHabiles);
            spnPiernaHabilJugador.setSelection(adapterPiernasHabiles.getPosition(MainActivity.jugadorSeleccionadoAEditar.getPiernaHabil()));
            etFechaNacJugador.setText(MainActivity.jugadorSeleccionadoAEditar.getFechaNacimiento());


            etNotasJugador.setText(MainActivity.jugadorSeleccionadoAEditar.getNotas());
            if (MainActivity.jugadorSeleccionadoAEditar.isDisponible())
                swtDisponible.setChecked(true);
            else
                swtDisponible.setChecked(false);

        } else {
            // Si el jugador es nulo, se trata de una creación
            // Se rellena el spinner con los números disponibles
            consultarNumerosSpinner();
            ArrayAdapter<String> adapterNumeros = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, numerosDisponibles);
            spnNumeroJugador.setAdapter(adapterNumeros);

            listarPosiciones();
            ArrayAdapter<String> adapterPosiciones = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPosiciones);
            spnPosicionJugador.setAdapter(adapterPosiciones);

            listarPiernasHabiles();
            ArrayAdapter<String> adapterPiernasHabiles = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPiernasHabiles);
            spnPiernaHabilJugador.setAdapter(adapterPiernasHabiles);
            swtDisponible.setChecked(true);

        }

        tvAceptar.setOnClickListener(v -> {
            comprobarCampos();
            TextView tv_siError = findViewById(R.id.tv_SiError);
            if (tv_siError.getText().toString().isEmpty()) {
                insertarOEditarJugador();
                /*Intent intent = new Intent(this, EditarEquipo.class);
                startActivity(intent);*/
                finish();
            }


        });

        ImageButton menuHaburguesa = findViewById(R.id.burguer_menu);
        menuHaburguesa.setOnClickListener(v -> {
            DialogMenuHamburguesa dialogMenuHamburguesa = new DialogMenuHamburguesa();
            dialogMenuHamburguesa.show(getSupportFragmentManager(), "Menu");
        });

        ImageButton atras = findViewById(R.id.atras);
        atras.setOnClickListener(v -> {
            finish();
        });
    }

    public void clickFecha() {

        dialogoFecha.show(getSupportFragmentManager(), "datePicker");

    }

    public void listarPosiciones() {

        listaPosiciones = new ArrayList<String>();
        listaPosiciones.add("Portero");
        listaPosiciones.add("Defensa");
        listaPosiciones.add("Centrocampista");
        listaPosiciones.add("Delantero");
    }

    public void listarPiernasHabiles() {
        listaPiernasHabiles = new ArrayList<String>();
        listaPiernasHabiles.add("Derecha");
        listaPiernasHabiles.add("Izquierda");
        listaPiernasHabiles.add("Ambas");
    }

    public void consultarNumerosSpinner() {
        // Se rellena el spinner con los números disponibles
        // Se consulta a la base de datos los números que no están ocupados

        // Se rellena el spinner de numeros disponibles para despues quitar los que ya esten ocupados
        for (int i = 1; i <= 99; i++) {
            numerosDisponibles.add(String.valueOf(i));
        }


        ArrayList<String> numerosOcupados = new ArrayList<>();
        Cursor cursor = MainActivity.database.rawQuery("SELECT * FROM jugadores WHERE equipo = '" + MainActivity.equipoSeleccionadoAEditar + "'", null);
        if (cursor.getCount() == 0)
            System.out.println("No hay jugadores en la base de datos");
        else {
            while (cursor.moveToNext()) {
                numerosOcupados.add(cursor.getString(3));
            }
        }
        // Se eliminan los números ocupados de los disponibles
        numerosDisponibles.removeAll(numerosOcupados);
        if (MainActivity.jugadorSeleccionadoAEditar != null) {
            numerosDisponibles.add(MainActivity.jugadorSeleccionadoAEditar.getDorsal());
        }
        numerosDisponibles.sort((o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
    }

    public void comprobarCampos() {
        EditText etNombreJugador = findViewById(R.id.et_nombreJugadorInsertado);
        EditText etPesoJugador = findViewById(R.id.et_pesoJugadorInsertado);
        EditText etAlturaJugador = findViewById(R.id.et_alturaJugadorInsertado);
        EditText etFechaNacJugador = findViewById(R.id.et_fechaNacJugadorInsertado);
        TextView tvSiError = findViewById(R.id.tv_SiError);
        if (etNombreJugador.getText().toString().isEmpty()) {
            tvSiError.setText("El nombre es obligatorio");
        } else if (etPesoJugador.getText().toString().isEmpty()) {
            tvSiError.setText("El peso es obligatorio");
        } else if (etAlturaJugador.getText().toString().isEmpty()) {
            tvSiError.setText("La altura es obligatoria");
        } else if (etFechaNacJugador.getText().toString().isEmpty()) {
            tvSiError.setText("La fecha de nacimiento es obligatoria");
        } else {
            tvSiError.setText("");
        }
    }

    public void insertarOEditarJugador() {
        EditText etNombreJugador = findViewById(R.id.et_nombreJugadorInsertado);
        Spinner spnNumeroJugador = findViewById(R.id.spn_dorsalJugadorInsertado);
        Spinner spnPosicionJugador = findViewById(R.id.spn_posicionJugadorInsertado);
        EditText etPesoJugador = findViewById(R.id.et_pesoJugadorInsertado);
        EditText etAlturaJugador = findViewById(R.id.et_alturaJugadorInsertado);
        EditText etFechaNacJugador = findViewById(R.id.et_fechaNacJugadorInsertado);

        Spinner spnPiernaHabilJugador = findViewById(R.id.spn_piernaHabilJugadorInsertado);
        EditText etNotasJugador = findViewById(R.id.et_notasJugadorInsertado);
        Switch swtDisponible = findViewById(R.id.swt_jugadorDisponible);

        //Se inserta el jugador en la base de datos
        String nombre = etNombreJugador.getText().toString();
        String dorsal = spnNumeroJugador.getSelectedItem().toString();
        String posicion = spnPosicionJugador.getSelectedItem().toString();
        String peso = etPesoJugador.getText().toString();
        String altura = etAlturaJugador.getText().toString();
        String fechaNacimiento = etFechaNacJugador.getText().toString();
        String piernaHabil = spnPiernaHabilJugador.getSelectedItem().toString();
        String notas = etNotasJugador.getText().toString();
        int disponible = 0;
        if (swtDisponible.isChecked())
            disponible = 1;

        if (MainActivity.jugadorSeleccionadoAEditar != null) {
            // Si el jugador no es nulo, se trata de una edición
            MainActivity.database.execSQL("UPDATE jugadores SET nombre = '" + nombre + "', dorsal = '" + dorsal + "', posicion = '" + posicion + "', peso = '" + peso + "', altura = '" + altura + "', fechaNacimiento = '" + fechaNacimiento + "', piernaHabil = '" + piernaHabil + "', notas = '" + notas + "', disponible = " + disponible + " WHERE id = " + MainActivity.jugadorSeleccionadoAEditar.getId());
        } else {
            // Si el jugador es nulo, se trata de una creación
            MainActivity.database.execSQL("INSERT INTO jugadores (equipo, nombre, dorsal, posicion, peso, altura, fechaNacimiento, piernaHabil, notas, disponible) " +
                    "VALUES ('" + MainActivity.equipoSeleccionadoAEditar + "', '" + nombre + "', '" + dorsal + "', '" + posicion + "', '" + peso + "', '" + altura + "', '" + fechaNacimiento + "', '" + piernaHabil + "', '" + notas + "', " + disponible + ")");
        }
    }

    @Override
    public void onBackPressed() {
    }
}