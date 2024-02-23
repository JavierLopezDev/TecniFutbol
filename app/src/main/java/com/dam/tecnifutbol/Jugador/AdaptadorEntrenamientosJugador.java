package com.dam.tecnifutbol.Jugador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.EntrenamientoJugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class AdaptadorEntrenamientosJugador extends RecyclerView.Adapter<AdaptadorEntrenamientosJugador.ViewHolderEntr> {
    private ArrayList<EntrenamientoJugador> entrenamientoJugador;

    public AdaptadorEntrenamientosJugador(ArrayList<EntrenamientoJugador> entrenamientoJugador) {
        this.entrenamientoJugador = entrenamientoJugador;
    }

    @NonNull
    @Override
    public ViewHolderEntr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_entrenamiento_jugador, parent, false);
        return new AdaptadorEntrenamientosJugador.ViewHolderEntr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEntr holder, int position) {
        EntrenamientoJugador entrenamiento = entrenamientoJugador.get(position);
        holder.tituloEntrJug.setText(entrenamiento.getNombre());
        holder.imagenEntrJug.setImageResource(entrenamiento.getImagen());
        holder.descripcionEntrJug.setText(entrenamiento.getDescripcion());

        holder.itemView.setOnClickListener((View.OnClickListener) view -> {
            MainActivity.nombreEntrJug = entrenamiento.getNombre();
            MainActivity.descripcionEntrJug = entrenamiento.getDescripcion();
            MainActivity.lugarEntrJug = entrenamiento.getLugar();
            MainActivity.repeticionesEntrJug = entrenamiento.getRepeticiones();
            MainActivity.notaEntrJug = entrenamiento.getNota();
            MainActivity.imagenEntrJug = entrenamiento.getImagen();
            MainActivity.videoEntrJug = entrenamiento.getVideo();

            Intent intent = new Intent(view.getContext(), DetallesEntrenamientoJugador.class);
            view.getContext().startActivity(intent);
        });
    }

        @Override
    public int getItemCount() {
        return entrenamientoJugador.size();
    }

    public static class ViewHolderEntr extends RecyclerView.ViewHolder {
        private ImageView imagenEntrJug;
        private TextView tituloEntrJug;
        private TextView descripcionEntrJug;

        public ViewHolderEntr(@NonNull View itemView) {
            super(itemView);

            imagenEntrJug = itemView.findViewById(R.id.imagenEntrJug);
            tituloEntrJug = itemView.findViewById(R.id.tituloEntrJug);
            descripcionEntrJug = itemView.findViewById(R.id.descripcionEntrJug);
        }
    }
}
