package com.dam.tecnifutbol.Entrenador.Partidos;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.R;

import java.util.List;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.ViewHolder> {
    private static final int MENU_GOL_LOCAL = R.id.menu_gol_local;
    private static final int MENU_GOL_VISITANTE = R.id.menu_gol_visitante;
    private static final int MENU_FALTA = R.id.menu_falta;
    private static final int MENU_TARJETA_ROJA = R.id.menu_tarjeta_roja;
    private static final int MENU_TARJETA_AMARILLA = R.id.menu_tarjeta_amarilla;
    private List<Jugador> jugadores;

    public JugadorAdapter(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_jugadores_partidoencurso, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Jugador jugador = jugadores.get(position);
        holder.textViewName.setText(jugador.getNombre());
        holder.textViewPosition.setText(jugador.getPosicion());
    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPosition = itemView.findViewById(R.id.textViewPosition);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarMenuOpciones(v);

                }
            });
        }
        private void mostrarMenuOpciones(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.menu_opciones_jugador);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case 0:
                            Toast.makeText(itemView.getContext(), "Gol local", Toast.LENGTH_SHORT).show();
                            return true;
                        case 1: // Índice del segundo elemento del menú
                            Toast.makeText(itemView.getContext(), "Gol visitante", Toast.LENGTH_SHORT).show();
                            return true;
                        case 2: // Índice del tercer elemento del menú
                            Toast.makeText(itemView.getContext(), "Falta", Toast.LENGTH_SHORT).show();
                            return true;
                        case 3: // Índice del cuarto elemento del menú
                            Toast.makeText(itemView.getContext(), "Tarjeta roja", Toast.LENGTH_SHORT).show();
                            return true;
                        case 4: // Índice del quinto elemento del menú
                            Toast.makeText(itemView.getContext(), "Tarjeta amarilla", Toast.LENGTH_SHORT).show();
                            return true;
                        default:
                            return false;
                    }
                }
            });
            popupMenu.show();
        }
    }
}
