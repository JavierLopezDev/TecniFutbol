package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;

public class AdaptadorEntrenamientos extends RecyclerView.Adapter<AdaptadorEntrenamientos.ViewHolder> {
    private ArrayList<Entrenamiento> entrenamientos;

    public AdaptadorEntrenamientos(ArrayList<Entrenamiento> entrenamientos) {
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
        Entrenamiento entrenamiento = entrenamientos.get(position);
        holder.nombreEntrenamiento.setText(entrenamiento.getNombre());
        holder.imagenEntrenamiento.setImageResource(entrenamiento.getImagen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.nombreEntrenamiento = entrenamiento.getNombre();
                MainActivity.descripcionEntrenamiento = entrenamiento.getDescripcion();
                MainActivity.edadesEntrenamiento = entrenamiento.getEdadesCategoria();
                MainActivity.dificultadEntrenamiento = entrenamiento.getDificultad();
                MainActivity.duracionEntrenamiento = entrenamiento.getDuracion();
                MainActivity.materialesEntrenamiento = entrenamiento.getMateriales();
                MainActivity.tipoEntrenamiento = entrenamiento.getTipo();
                MainActivity.videoEntrenamiento = entrenamiento.getVideo();

                Intent intent = new Intent(view.getContext(), DetallesEntrenamiento.class);
                view.getContext().startActivity(intent);

                /*Intent intent = new Intent(view.getContext(), DetallesEntrenamiento.class);
                intent.putExtra("nombreEntrenamiento", entrenamiento.getNombre());
                intent.putExtra("descripcionEntrenamiento", entrenamiento.getDescripcion());
                intent.putExtra("edadesEntrenamiento", entrenamiento.getEdadesCategoria());
                intent.putExtra("dificultadEntrenamiento", entrenamiento.getDificultad());
                intent.putExtra("duracionEntrenamiento", entrenamiento.getDuracion());
                intent.putExtra("materialesEntrenamiento", entrenamiento.getMateriales());
                intent.putExtra("tipoEntrenamiento", entrenamiento.getTipo());
                intent.putExtra("videoEntrenamiento", entrenamiento.getVideo());
                view.getContext().startActivity(intent);*/
            }
        });
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
