package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class AdaptadorEntrenamientos extends RecyclerView.Adapter<AdaptadorEntrenamientos.ViewHolder> {
    private ArrayList<String> entrenamientos;

    public AdaptadorEntrenamientos(ArrayList<String> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_seleccion_equipo, parent, false);
        return new AdaptadorEntrenamientos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreEntrenamiento;
        //private ImageView imagenEntrenamiento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreEntrenamiento = itemView.findViewById(R.id.nombreEntrenamiento);
            //imagenEntrenamiento = itemView.findViewById(R.id.imagenEntrenamiento);
        }
    }
}
