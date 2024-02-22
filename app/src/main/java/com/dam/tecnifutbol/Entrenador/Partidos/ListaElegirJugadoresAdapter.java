package com.dam.tecnifutbol.Entrenador.Partidos;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.Modelo.Jugador;
import com.dam.tecnifutbol.R;

import java.util.ArrayList;


public class ListaElegirJugadoresAdapter extends RecyclerView.Adapter<ListaElegirJugadoresAdapter.ViewHolder> {

    private ArrayList<Jugador> localDataSet;
    private int maximoJugadoresSeleccionados;


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
        private LinearLayout linearLayout = null;

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

    public ListaElegirJugadoresAdapter(ArrayList<Jugador> localDataSet, int maximoJugadoresSeleccionados) {
        this.localDataSet = localDataSet;
        this.maximoJugadoresSeleccionados = maximoJugadoresSeleccionados;
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
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
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
                    String dorsal = localDataSet.get(position).getDorsal();
                    System.out.println("Dorsal en click: " + dorsal);
                    if (MainActivity.bandoSeleccionadoEnElegirJugadores.equalsIgnoreCase("equipo 1")) {
                        comprobarEntreListas(MainActivity.jugadoresSuplentesSeleccionados,dorsal, linearLayout);
                        if (linearLayout.isClickable()){

                            comprobarJugadorTitularSeleccionado(linearLayout,dorsal , maximoJugadoresSeleccionados);
                        }

                    } else if (MainActivity.bandoSeleccionadoEnElegirJugadores.equalsIgnoreCase("equipo 2")) {
                        comprobarEntreListas(MainActivity.jugadoresTitularesSeleccionados,dorsal, linearLayout);
                        if (linearLayout.isClickable()){
                            comprobarJugadorSuplenteSeleccionado(linearLayout,dorsal, maximoJugadoresSeleccionados);
                        }

                    }

                }
            }
        });
        //Log.i("onBindViewHolder()", viewHolder.textView + " : " + position);
    }




    //Se comprueba si el jugador ya ha sido seleccionado, y se saca de la lista, habra un maximo de jugadores seleccionados
    public void comprobarJugadorTitularSeleccionado(LinearLayout linearLayout, String dorsalJugador, int maximoJugadores) {
        System.out.println("Comprobando titulares");
        if (MainActivity.jugadoresTitularesSeleccionados == null) {
            MainActivity.jugadoresTitularesSeleccionados = new ArrayList<>();
        }
        if (MainActivity.jugadoresTitularesSeleccionados.contains(dorsalJugador)) {
            MainActivity.jugadoresTitularesSeleccionados.remove(dorsalJugador);
            restaurarEstiloJugador(linearLayout);
            System.out.println("Eliminado de la lista titular : "+dorsalJugador);
        } else {
            if (MainActivity.jugadoresTitularesSeleccionados.size() < maximoJugadores) {
                MainActivity.jugadoresTitularesSeleccionados.add(dorsalJugador);
                cambiarEstilojugadorSeleccionado(linearLayout);
                System.out.println("Añadido a la lista titular : "+dorsalJugador);
            } else {
                //Notificar al usuario que no puede seleccionar mas jugadores con un toast
                System.out.println("No se pueden seleccionar mas jugadores en titulares");
                //Muestro el contenido de la lista para pruebas
                for (String dorsal : MainActivity.jugadoresTitularesSeleccionados) {
                    System.out.println(dorsal);
                }
                System.out.println("Se ha comprobado el:"+dorsalJugador);
            }
        }
    }

    public void comprobarJugadorSuplenteSeleccionado(LinearLayout linearLayout,String dorsalJugador,  int maximoJugadores) {
        System.out.println("Comprobando suplentes");
        if (MainActivity.jugadoresSuplentesSeleccionados == null) {
            MainActivity.jugadoresSuplentesSeleccionados = new ArrayList<>();
        }
        if (MainActivity.jugadoresSuplentesSeleccionados.contains(dorsalJugador)) {
            MainActivity.jugadoresSuplentesSeleccionados.remove(dorsalJugador);
            restaurarEstiloJugador(linearLayout);
            System.out.println("Eliminado de la lista de suplentes : "+dorsalJugador);
        } else {
            if (MainActivity.jugadoresSuplentesSeleccionados.size() < maximoJugadores) {
                MainActivity.jugadoresSuplentesSeleccionados.add(dorsalJugador);
                linearLayout.setBackgroundResource(R.drawable.botonseleccionadorojo);
                System.out.println("Añadido a la lista de suplentes : "+dorsalJugador);
            } else {
                //Notificar al usuario que no puede seleccionar mas jugadores con un toast
                System.out.println("No se pueden seleccionar mas jugadores en titulares");
            }
        }
    }

    public void comprobarEntreListas(ArrayList<String> listaAComprobar, String dorsalJugadorClick, LinearLayout linearLayout) {
        System.out.println("Entra a ComprobarEntreListas");
        //Recorrer la listaAComprobar
        for (String dorsalJugador : listaAComprobar) {
            System.out.println(dorsalJugador+ "comprobara "+dorsalJugadorClick);
            if (dorsalJugador == dorsalJugadorClick) {
                linearLayout.setEnabled(false);
                linearLayout.setClickable(false);
                System.out.println("Deshabilitado "+dorsalJugador);
            }
            else {
                linearLayout.setEnabled(true);
                linearLayout.setClickable(true);
                System.out.println("Habilitado "+dorsalJugador);
            }
        }
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

