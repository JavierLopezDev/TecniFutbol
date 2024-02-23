package com.dam.tecnifutbol.Entrenador.Partidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;


public class ListaJugadoresAdapter extends RecyclerView.Adapter<ListaJugadoresAdapter.ViewHolder> {

    private ArrayList<Jugador> localDataSet;
    private LinearLayout ultimoLinearSeleccionado;

    public interface cardViewListener {
        void onCardViewClick();
    }

    private cardViewListener listener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNumero;
        private final TextView textViewNombre;
        private final TextView textViewPosicion;
        private  LinearLayout linearLayout = null;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewNumero = view.findViewById(R.id.tv_numeroJugador);
            textViewNombre = view.findViewById(R.id.tv_nombreJugador);
            textViewPosicion = view.findViewById(R.id.tv_posicionJugador);
            linearLayout = view.findViewById(R.id.layoutJugadores);
        }

        public TextView getTextViewNombre() {
            return textViewNombre;
        }

        public TextView getTextViewNumero() {
            return textViewNumero;
        }

        public TextView getTextViewPosicion() {
            return textViewPosicion;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

    }

    public ListaJugadoresAdapter(ArrayList<Jugador> localDataSet) {
        this.localDataSet = localDataSet;
    }

    /**
     * Initialize the dataset of the Adapter.
     * <p>
     * by RecyclerView.
     */


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_grid_jugadores, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int posicion = position;
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextViewNombre().setText(localDataSet.get(position).getNombre());
        viewHolder.getTextViewNumero().setText(localDataSet.get(position).getDorsal());
        viewHolder.getTextViewPosicion().setText(localDataSet.get(position).getPosicion());
        viewHolder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getClass().getSimpleName().equals("LinearLayout")) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    //Cambiar estilo del jugador seleccionado a la vez que deselecciono el anterior
                    if (ultimoLinearSeleccionado != null) {
                        restaurarEstiloJugador(ultimoLinearSeleccionado);
                    }
                    ultimoLinearSeleccionado = linearLayout;
                    MainActivity.jugadorSeleccionadoAEditar= localDataSet.get(posicion);
                    MainActivity.jugadorSeleccionadoAEditarOEliminar = localDataSet.get(posicion).getId();
                    cambiarEstilojugadorSeleccionado(linearLayout);
                }
            }
        });

        //Log.i("onBindViewHolder()", viewHolder.textView + " : " + position);
    }

    public void cambiarEstilojugadorSeleccionado(LinearLayout linearLayout) {
        linearLayout.setBackgroundResource(R.drawable.botonseleccionado);
    }

    public void restaurarEstiloJugador(LinearLayout linearLayout) {
        linearLayout.setBackgroundResource(R.drawable.boton);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

