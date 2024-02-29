package com.dam.tecnifutbol.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.Objects;
import java.util.zip.Inflater;

public class DialogoAjustesPartido extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Ajustes del partido");

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View vistaAjustes = inflater.inflate(R.layout.dialogo_ajustes_partido, null);
        builder.setView(vistaAjustes);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText etPartesPartido = vistaAjustes.findViewById(R.id.et_partesPartido);
                EditText etDuracionParte = vistaAjustes.findViewById(R.id.et_duracionPartes);

                MainActivity.partesPartido = String.valueOf(etPartesPartido.getText());
                MainActivity.duracionParte = String.valueOf(etDuracionParte.getText());
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.partesPartido = "2";
                MainActivity.duracionParte = "45";
            }
        });

        return builder.create();
    }
}
