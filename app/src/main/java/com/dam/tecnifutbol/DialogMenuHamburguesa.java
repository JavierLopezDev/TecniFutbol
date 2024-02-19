package com.dam.tecnifutbol;

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

public class DialogMenuHamburguesa extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] actividades = {"Pantalla Inicial", "Pantalla Entrenador", "Pantalla Entrenamientos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, actividades);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Menú");
        builder.setAdapter(adapter, (dialog, which) -> {
            switch (which) {
                case 0:
                    Intent intent = new Intent(getActivity(), PantallaInicial.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent2 = new Intent(getActivity(), PantallaEntrenador.class);
                    startActivity(intent2);
                    break;
                case 2:
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