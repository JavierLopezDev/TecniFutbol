package com.dam.tecnifutbol.Entrenador.Partidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.R;

import java.util.ArrayList;
import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.EquipoViewHolder> {

    private List<Equipo> listaEquipos;
    private Context context;
    private List<Equipo> equiposSeleccionados;

    public RecyclerViewAdapter(Context context, List<Equipo> listaEquipos) {
        this.context = context;
        this.listaEquipos = listaEquipos;
        this.equiposSeleccionados = new ArrayList<>();
    }

    @NonNull
    @Override
    public EquipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_entrenamientos, parent, false);
        return new EquipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoViewHolder holder, int position) {
        Equipo equipo = listaEquipos.get(position);
        holder.bind(equipo);

        // Agregar el oyente de clic al ViewHolder
        holder.itemView.setOnClickListener(view -> {
            // Alternar la selección del equipo
            toggleSeleccion(equipo);
            // Actualizar la apariencia del ViewHolder según la selección
            actualizarApariencia(holder, equipo);
        });
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    // Método para actualizar la lista de equipos
    public void actualizarEquipos(List<Equipo> nuevosEquipos) {
        listaEquipos.clear();
        listaEquipos.addAll(nuevosEquipos);
        notifyDataSetChanged();
    }

    // Método para obtener los equipos seleccionados
    public List<Equipo> getEquiposSeleccionados() {
        return equiposSeleccionados;
    }

    public static class EquipoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenEntrenamiento;
        private TextView nombreEntrenamiento;
        private TextView categoriaEntrenamiento;

        public EquipoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenEntrenamiento = itemView.findViewById(R.id.imagenEntrenamiento);
            nombreEntrenamiento = itemView.findViewById(R.id.nombreEntrenamiento);
            categoriaEntrenamiento = itemView.findViewById(R.id.categoriaEntrenamiento);
        }

        public void bind(Equipo equipo) {
            nombreEntrenamiento.setText(equipo.getNombre());
            categoriaEntrenamiento.setText(equipo.getCategoria());
            imagenEntrenamiento.setImageResource(R.drawable.equipo);
        }
    }

    private void toggleSeleccion(Equipo equipo) {
        if (equiposSeleccionados.contains(equipo)) {
            equiposSeleccionados.remove(equipo);
        } else {
            equiposSeleccionados.add(equipo);
        }
    }

    private void actualizarApariencia(EquipoViewHolder holder, Equipo equipo) {
        if (equiposSeleccionados.contains(equipo)) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.purple_700));
        } else {
            holder.itemView.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }
    }
}
