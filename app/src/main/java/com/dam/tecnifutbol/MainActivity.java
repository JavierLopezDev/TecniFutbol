package com.dam.tecnifutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.dam.tecnifutbol.R;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creación de la base de datos y la tabla entrenamientos
        database = openOrCreateDatabase("TecniFutbol", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS entrenamientos " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, descripcion TEXT, tipoEjercicio TEXT, categoriaEdad TEXT, dificultad TEXT, " +
                "duracion TEXT, material TEXT)");
    }

    /**
     * Inserta en la BD los entrenamientos de las diferentes categorías de edad.
     */
    private void insertarEntrenamientos() {
        Cursor cursor = database.rawQuery("SELECT * FROM entrenamientos", null);

        if (cursor.getCount() == 0) {
            insertarEntrenamientosDeMenos8Años();
            insertarEntrenamientosDe8A11Años();
            insertarEntrenamientosDe11A14Años();
            insertarEntrenamientosDe14A18Años();
            insertarEntrenamientosDeMas18Años();
        }
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de menos de 8 años.
     */
    private void insertarEntrenamientosDeMenos8Años() {
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Despejes orientados', " +
                "'Los defensas se posicionan en sus respectivas demarcaciones. " +
                "Se colocan cerca del centro del campo 3 ó 4 porterías pequeñas. " +
                "Dos o tres jugadores realizan envíos largos al área desde posiciones de medio campo. " +
                "Los defensas tratarán de despejar dirigiendo el balón hacia cualquiera de las porterías" +
                " pequeñas con la intención de introducir en balón en éstas.', " +
                "'Defensa', 'Menos de 8 años', 'Baja', '10 minutos', 'Conos, 3 balones, 5-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Porteros en diagonal', " +
                "'2 porteros se colocan en diagonal sobre un cuadrado formado por pivotes. " +
                "A la señal los porteros lanzan su balón al pivote que tienen enfrente y el otro portero deberá de blocarlo. " +
                "Se comenzará lentamente y se subirá el ritmo progresivamente.', " +
                "'Porteros', 'Menos de 8 años', 'Media', '5 minutos', 'Conos, 2 balones, 2-4 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Doble remate a portería', " +
                "'X1 trás recibir el pase de X2 conduce unos metros y encara la primera portería. " +
                "Después de realizar un cambio de ritmo X1 se dirige a la segunda portería para recibir el pase de X3.', " +
                "'Tiro', 'Menos de 8 años', 'Media', '25 minutos', '2 balones, 2 porterías, 3-20 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Circuito de Agilidad-Regate 4', " +
                "'Circuito variado. " +
                "Primero se realizan las acciones técnicas y luego las físicas. " +
                "El circuito contiene acciones como: " +
                "-Rodear la pica después de haber realizado un regate. " +
                "-Pase y skiping doble apoyo. " +
                "-Pase pared,paso por debajo de valla y voltereta.', " +
                "'Circuitos', 'Menos de 8 años', 'Media', '15 minutos', 'Conos, Picas, Colchonetas, 2 balones, 5-20 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Pared, pase en profundidad y tiro', " +
                "'Pase y devolución entre los jugadores X1 y X3. " +
                "X2 realizará un desmarque de ruptura en el momento en el que X1 realice un pase elevado. " +
                "X2 optará por el disparo directo ó bien por realizar un control previo.', " +
                "'Pase, Tiro', 'Menos de 8 años', 'Media', '15 minutos', 'Pivotes, 1 balón, 1 portería, 3-20 jugadores')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 8 a 11 años.
     */
    private void insertarEntrenamientosDe8A11Años() {
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Realiza la pared y chuta', " +
                "'Sucesión de pases entre 4 jugadores en la que se realiza una acción de pared o regate y se culmina con tiro. " +
                "x1 realiza un pase y devolución con x4, posteriormente pase a x2. " +
                "x2 pasa a x3. " +
                "x3 conduce y realiza una acción de pared con x2 o bien regatea por el otro lado la oposición de x4. " +
                "x3 finaliza la acción con un tiro a puerta.', " +
                "'Pase, Tiro, Regate', '8 a 11 años', 'Máxima', '15 minutos', 'Pivotes, 1 balón, 1 portería, 4-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Las 4 esquinas', " +
                "'El juego de las 4 esquinas. " +
                "A la voz del entrenador todos los jugadores cambiarán de pivotes. " +
                "4 jugadores siempre quedarán fuera.', " +
                "'Calentamiento, Velocidad', '8 a 11 años', 'Baja', '10 minutos', 'Pivotes, 12-20 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Maniobra y pase', " +
                "'Se delimitan dos cuadros con conos(uno más pequeño en el interior del ótro). " +
                "Dos jugadores se sitúan en paralelo fuera del recuadro grande y 2 centrocampistas se sitúan en el interior del pequeño. " +
                "El objetivo que persegirán los centrocampistas será combinar con el jugador del lado contrario al que recibió el balón', " +
                "'Pase, Orientación', '8 a 11 años', 'Media', '15 minutos', 'Pivotes, Petos, 1 balón, 3-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Salto y parada', " +
                "'Se sitúan 3 conos separados 3 metros entre si y el portero se sitúa en uno de los extremos. " +
                "El portero deberá desplazarse lateralmente hasta el cono del medio y cuando le tiren el balón elevarse por encima de éste e intentar blocar el balón. " +
                "A continuación se levanta y realiza la misma acción en el mismo sentido', " +
                "'Porteros', '8 a 11 años', 'Media', '10 minutos', 'Pivotes, 1 balón, 1 jugador(Portero)')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Saltos de vallas y finalización', " +
                "'El delantero que finalizará la acción sale en sprint desde el borde del área y salta con los pies juntos por encima de las vallas. " +
                "Tras superar las vallas gira alrededor del cono y corre en dirección a portería en busca del pase elevado que le envía su compañero. " +
                "Tras finalizar la acción se intercambian las posiciones', " +
                "'Circuitos, Tiro', '8 a 11 años, Más de 18 años', 'Máxima', '15 minutos', 'Pivotes, Vallas, 1 balón, 1 portería, 2-24 jugadores')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 11 a 14 años.
     */
    private void insertarEntrenamientosDe11A14Años() {
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Defensa en inferioridad con relevo', " +
                "'Se delimita un terreno de juego en forma de cuadro. " +
                "Dentro se sitúan 3 atacantes contra 2 defensores. " +
                "Los defensores deben realizar 5 recuperaciones de balón para pasarselos a los atacantes. " +
                "Cada vez que recuperan un balón o provocan una pérdida uno de los defensores se relevará con el tercer compañero que se encuentra fuera del cuadro descansando', " +
                "'Defensa', '11 a 14 años', 'Media', '20 minutos', 'Pivotes, Petos, 1 balón, 6-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Circuito técnico', " +
                "'El portero deberá parar diferentes tipos de tiros a portería desde distintos ángulos. " +
                "1-Balón colgado al área. " +
                "2- Realizar una voltereta y detener un tiro desde el vértice del área. " +
                "3-Golpeo frontal. " +
                "4-Golpeo frontal desde más lejos. " +
                "5-Voltereta y detener un tiro desde el otro vértice. " +
                "6-Balón colgado', " +
                "'Porteros', '11 a 14 años', 'Alta', '10 minutos', 'Pivotes, 6 balones, 1 portería, 6 jugadores, 1 portero')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Saque de banda 2', " +
                "'Saque de banda a los pies de X1 ante su movimiento de apoyo. " +
                "X1 devuelve el balón raso al sacador quien controla y realiza un pase en profundidad hacia el desmarque de X2. " +
                "X2 finaliza la acción con disparo a puerta', " +
                "'Saque de banda', '11 a 14 años, Más de 18 años', 'Alta', '15 minutos', '1 balón, 1 portería, 3-20 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Juego estrategia de córner', " +
                "'Se divide a la plantilla en 3 equipos y se sitúan 4 jugadores para sacar córners. " +
                "En cada córner juegan un equipo defensor contra un equipo atacante. " +
                "Si se consigue gol se sigue atacando en la otra portería, si es el equipo defensor quien logra despejar, éste será quien pase a atacar. " +
                "Cada vez se saca de una esquina diferente. " +
                "Se van sumando los goles conseguidos por cada equipo', " +
                "'Corners', '11 a 14 años, Más de 18 años', 'Media', '25 minutos', 'Petos, 4 balones, 2 porterías, 13-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Partido 6 porterías', " +
                "'Dividir a la plantilla en 2 equipos. " +
                "Cada equipo defiende-ataca 3 porterías pequeñas situadas a lo largo de la línea de fondo. " +
                "El gol se conseguirá introduciendo el balón en cualquiera de las 3 porterías', " +
                "'Global', '11 a 14 años', 'Media', '35 minutos', 'Pivotes, Petos, 1 balón, 6 porterías, 12-20 jugadores')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 14 a 18 años.
     */
    private void insertarEntrenamientosDe14A18Años() {
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Defender el triángulo', " +
                "'Se delimita una zona triangular en el terreno marcada mediante conos. " +
                "El jugador defensor deberá defender las tres porterías resultantes pudiendo para ello atravesar el triángulo por el interior. " +
                "2 jugadores atacantes a través de combinaciones, conducciones... intentarán penetrar dentro del triángulo con balón. " +
                "Posteriormente se cambian las funciones', " +
                "'Defensa', '14 a 18 años', 'Alta', '20 minutos', 'Pivotes, Petos, 1 balón, 3-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Dinámica de cambios de orientación', " +
                "'Se divide el terreno de juego en 3 zonas (2 bandas y zona central). " +
                "El jugador situado en la zona central realiza una combinación corta con una de las bandas y efectúa un cambio de orientación en largo al compañero situado en la otra banda. " +
                "Los jugadores de banda tras realizar la combinación en corto realizan un sprint hasta la otra zona de campo de su propia banda', " +
                "'Orientación, Pase', '14 a 18 años', 'Media', '20 minutos', 'Pivotes, 2 balones, 6-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Velocidad de reacción, reflejos y lateralidad', " +
                "'El portero abre con la mano a un lateral. " +
                "Este da un pase al punto de penalti. " +
                "Un segundo jugador remata de cerca', " +
                "'Porteros, Tiro, Pase', '14 a 18 años', 'Media', '10 minutos', '1 balón, 1 portería, 3 jugadores, 1 portero')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Finalización desde fuera del área', " +
                "'Cambio de orientación mediante circulación de balón entre tres centrocampistas. " +
                "El medio centro recibe el balón de un medio de banda y tras apoyarse en el compañero de la otra banda realiza un cambio de orientación al desmarque realizado por su compañero. " +
                "El medio que inició la jugada realiza una dejada hacia atrás para que el medio centro finalice con tiro lejano la acción', " +
                "'Pase, Tiro', '14 a 18 años', 'Media', '25 minutos', 'Pivotes, 1 balón, 1 portería, 3-24 jugadores')");
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material)" +
                " VALUES ('Superioridad 2x1 y finalización por banda', " +
                "'Se delimitan dos cuadros en banda donde se juegan posesiones 2x1 apoyados por un medio centro que sirve de enlace entre ambas. " +
                "Una vez que se consiguen 3 pases en cada una de éstas se puede buscar finalización de jugada mediante acción de centro por banda con incorporación al remate 2x1. " +
                "Si se consigue gol siguen defendiendo los mismos jugadores, sino se rotan las posiciones', " +
                "'Superioridad', '14 a 18 años, Más de 18 años', 'Alta', '25 minutos', 'Pivotes, Petos, 1 balón, 1 porterías, 10-24 jugadores')");
    }

    private void insertarEntrenamientosDeMas18Años(){
        database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material) " +
                "VALUES ('Juego de cabeza', " +
                "'Consiste en meter gol de cabeza. " +
                "No se pueden utilizar las manos. " +
                "Es una competición de 2 contra 2. " +
                "Cada pareja hace una vez de defensores y otra de atacantes', " +
                "'Cabeza, Pase, Velocida', 'Más de 18 años', 'Alta', '15 minutos', 'Pivotes, Petos, 1 balón, 4-20 jugadores')");
        // Los demas entrenamientos de esta edad son tambien de las otras edades son de las otras edades
    }
}