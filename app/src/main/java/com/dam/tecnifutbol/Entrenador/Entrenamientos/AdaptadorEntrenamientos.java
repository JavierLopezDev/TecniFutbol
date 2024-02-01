package com.dam.tecnifutbol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorEntrenamientos extends RecyclerView.Adapter<AdaptadorEntrenamientos.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_entrenamientos, parent, false);
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
        private ImageView imagenEntrenamiento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreEntrenamiento = itemView.findViewById(R.id.nombreEntrenamiento);
            imagenEntrenamiento = itemView.findViewById(R.id.imagenEntrenamiento);
        }
    }
}
