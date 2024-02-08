package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class AdaptadorEntrenamientos extends RecyclerView.Adapter<AdaptadorEntrenamientos.ViewHolder> {
    private ArrayList<EntrenamientoConImagen> entrenamientos;

    public AdaptadorEntrenamientos(ArrayList<EntrenamientoConImagen> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_entrenamientos, parent, false);
        return new AdaptadorEntrenamientos.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EntrenamientoConImagen entrenamiento = entrenamientos.get(position);
        holder.nombreEntrenamiento.setText(entrenamiento.getNombre());
        holder.imagenEntrenamiento.setImageResource(entrenamiento.getImagen());
    }

    @Override
    public int getItemCount() {
        return entrenamientos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreEntrenamiento;
        private ImageView imagenEntrenamiento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreEntrenamiento = itemView.findViewById(R.id.nombreEntrenamiento);
            imagenEntrenamiento = itemView.findViewById(R.id.imagenEntrenamiento);
        }
    }
}
