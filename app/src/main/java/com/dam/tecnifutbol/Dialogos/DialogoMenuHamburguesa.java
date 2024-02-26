package com.dam.tecnifutbol.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.dam.tecnifutbol.Entrenador.Entrenamientos.PantallaEntrenamientos;
import com.dam.tecnifutbol.Entrenador.PantallaEntrenador;
import com.dam.tecnifutbol.Jugador.PantallaJugador;
import com.dam.tecnifutbol.PantallaInicial;

public class DialogoMenuHamburguesa extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] actividades = {"Incio", "Entrenador", "Jugador", "Entrenamientos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, actividades);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        /*builder.setTitle("Menú");*/
        builder.setAdapter(adapter, (dialog, which) -> {
            switch (which) {
                case 0:
                    Intent intent0 = new Intent(getActivity(), PantallaInicial.class);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(getActivity(), PantallaEntrenador.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getActivity(), PantallaJugador.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(getActivity(), PantallaEntrenamientos.class);
                    startActivity(intent3);
                    break;
            }
        });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}