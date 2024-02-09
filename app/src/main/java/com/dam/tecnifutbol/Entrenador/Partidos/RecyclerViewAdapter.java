package com.dam.tecnifutbol.Entrenador.Partidos;

import android.content.Context;
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
import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.EquipoViewHolder> {

    private List<Equipo> listaEquipos;
    private Context context;
    private Equipo equipoSeleccionado;

    public RecyclerViewAdapter(Context context, List<Equipo> listaEquipos) {
        this.context = context;
        this.listaEquipos = listaEquipos;
    }
    public List<Equipo> getEquiposSeleccionados() {
        List<Equipo> equiposSeleccionados = new ArrayList<>();
        if (equipoSeleccionado != null) {
            equiposSeleccionados.add(equipoSeleccionado);
        }
        return equiposSeleccionados;
    }


    @NonNull
    @Override
    public EquipoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_equipo_grid, parent, false);
        return new EquipoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoViewHolder holder, int position) {
        Equipo equipo = listaEquipos.get(position);
        holder.bind(equipo);

        // Agregar el oyente de clic al ViewHolder
        holder.itemView.setOnClickListener(view -> {
            // Deseleccionar el equipo anterior (si hay alguno)
            if (equipoSeleccionado != null) {
                int index = listaEquipos.indexOf(equipoSeleccionado);
                equipoSeleccionado = null;
                notifyItemChanged(index);
            }
            // Seleccionar el nuevo equipo
            equipoSeleccionado = equipo;
            MainActivity.equipoSeleccionadoAEditar=equipoSeleccionado.getNombre();
            // Notificar el cambio en la posición actual
            notifyItemChanged(position);
        });

        // Actualizar la apariencia del ViewHolder según la selección
        if (equipo.equals(equipoSeleccionado)) {
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.purple_700));

        } else {
            holder.itemView.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }
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

    public static class EquipoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagenEntrenamiento;
        private TextView nombreEntrenamiento;
        private TextView categoriaEntrenamiento;

        public EquipoViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenEntrenamiento = itemView.findViewById(R.id.imagenEquipo);
            nombreEntrenamiento = itemView.findViewById(R.id.nombreEquipo);
            categoriaEntrenamiento = itemView.findViewById(R.id.categoriaEquipo);
        }

        public void bind(Equipo equipo) {
            nombreEntrenamiento.setText(equipo.getNombre());
            categoriaEntrenamiento.setText(equipo.getCategoria());
            imagenEntrenamiento.setImageResource(R.drawable.equipo);
        }

    }
}
