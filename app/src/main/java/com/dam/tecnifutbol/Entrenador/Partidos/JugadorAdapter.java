package com.dam.tecnifutbol.Entrenador.Partidos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    private static final int MENU_GOL_LOCAL = R.id.menu_gol;
    private static final int MENU_FALTA = R.id.menu_falta;
    private static final int MENU_TARJETA_ROJA = R.id.menu_tarjeta_roja;
    private static final int MENU_TARJETA_AMARILLA = R.id.menu_tarjeta_amarilla;
    private SQLiteDatabase database; // Agrega esta variable para acceder a la base de datos SQLite

    private List<JugadorEstadisticas> jugadores;
    private JugadorEstadisticas jugadorSeleccionado;

    public JugadorAdapter(List<JugadorEstadisticas> jugadores, SQLiteDatabase database) {
        this.jugadores = jugadores;
        this.database = database;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_jugadores_partidoencurso, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JugadorEstadisticas jugador = jugadores.get(position);
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
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        JugadorEstadisticas jugadorSeleccionado = jugadores.get(adapterPosition);
                        mostrarMenuOpciones(v, jugadorSeleccionado);
                    }
                }
            });
        }

        private void mostrarMenuOpciones(View view, JugadorEstadisticas jugadorSeleccionado) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.inflate(R.menu.menu_opciones_jugador);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.menu_gol) {
                        actualizarEstadisticas(jugadorSeleccionado, "goles", jugadorSeleccionado.getGoles() + 1);
                        Toast.makeText(itemView.getContext(), "Gol", Toast.LENGTH_SHORT).show();
                        return true;
                    } else if (itemId == R.id.menu_falta) {
                        actualizarEstadisticas(jugadorSeleccionado, "faltasRealizadas", jugadorSeleccionado.getFaltasRealizadas() + 1);
                        Toast.makeText(itemView.getContext(), "Falta", Toast.LENGTH_SHORT).show();
                        return true;
                    } else if (itemId == R.id.menu_tarjeta_roja) {
                        actualizarEstadisticas(jugadorSeleccionado, "tarjetasRojas", jugadorSeleccionado.getTarjetaRoja() + 1);
                        Toast.makeText(itemView.getContext(), "Tarjeta roja", Toast.LENGTH_SHORT).show();
                        return true;
                    } else if (itemId == R.id.menu_tarjeta_amarilla) {
                        actualizarEstadisticas(jugadorSeleccionado, "tarjetaAmarillas", jugadorSeleccionado.getTarjetaAmarilla() + 1);
                        Toast.makeText(itemView.getContext(), "Tarjeta amarilla", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            popupMenu.show();
        }



        private void actualizarEstadisticas(JugadorEstadisticas jugador, String columna, int nuevoValor) {
            String jugadorNombre = jugador.getNombre();
            Cursor cursor = database.rawQuery("SELECT * FROM estadisticas_jugador WHERE jugador = ?", new String[]{jugadorNombre});
            if (cursor.moveToFirst()) {
                String sql = "UPDATE estadisticas_jugador SET " + columna + " = " + nuevoValor + " WHERE jugador = ?";
                database.execSQL(sql, new String[]{jugadorNombre});
                Toast.makeText(itemView.getContext(), "Estadisticas introducidas", Toast.LENGTH_SHORT).show();

            } else {
                // El jugador no existe, lo creamos
                ContentValues values = new ContentValues();
                values.put("jugador", jugadorNombre);
                values.put(columna, nuevoValor);
                database.insert("estadisticas_jugador", null, values);
            }
            cursor.close();
            notifyDataSetChanged();
        }
    }
}
