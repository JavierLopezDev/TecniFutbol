package com.dam.tecnifutbol.Entrenador.Entrenamientos;

import android.net.Uri;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

public class InsertarEntrenamientos {
    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de menos de 8 años.
     */
    public static void insertarEntrenamientosDeMenos8Años() {
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Despejes orientados', " +
                "'Los defensas se posicionan en sus respectivas demarcaciones. " +
                "Se colocan cerca del centro del campo 3 ó 4 porterías pequeñas. " +
                "Dos o tres jugadores realizan envíos largos al área desde posiciones de medio campo. " +
                "Los defensas tratarán de despejar dirigiendo el balón hacia cualquiera de las porterías" +
                " pequeñas con la intención de introducir en balón en éstas.', " +
                "'Defensa', 'Menos de 8 años', 'Baja', '10 minutos', 'Conos, 3 balones, 5-24 jugadores', " +
                R.drawable.entrenamiento_despejes_orientados + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_despejes_orientados + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Porteros en diagonal', " +
                "'2 porteros se colocan en diagonal sobre un cuadrado formado por pivotes. " +
                "A la señal los porteros lanzan su balón al pivote que tienen enfrente y el otro portero deberá de blocarlo. " +
                "Se comenzará lentamente y se subirá el ritmo progresivamente.', " +
                "'Porteros', 'Menos de 8 años', 'Media', '5 minutos', 'Conos, 2 balones, 2-4 jugadores', " +
                R.drawable.entrenamiento_porteros_en_diagonal + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_porteros_en_diagonal + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Doble remate a portería', " +
                "'X1 trás recibir el pase de X2 conduce unos metros y encara la primera portería. " +
                "Después de realizar un cambio de ritmo X1 se dirige a la segunda portería para recibir el pase de X3.', " +
                "'Tiro', 'Menos de 8 años', 'Media', '25 minutos', '2 balones, 2 porterías, 3-20 jugadores', " +
                R.drawable.entrenamiento_doble_remate_a_porteria + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_doble_remate_a_porteria + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Circuito de Agilidad-Regate 4', " +
                "'Circuito variado. " +
                "Primero se realizan las acciones técnicas y luego las físicas. " +
                "El circuito contiene acciones como: " +
                "-Rodear la pica después de haber realizado un regate. " +
                "-Pase y skiping doble apoyo. " +
                "-Pase pared,paso por debajo de valla y voltereta.', " +
                "'Circuitos', 'Menos de 8 años', 'Media', '15 minutos', 'Conos, Picas, Colchonetas, 2 balones, 5-20 jugadores', " +
                R.drawable.entrenamiento_circuito_de_agilidad_regate_4 + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_circuito_de_agilidad_regate_4 + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Pared, pase en profundidad y tiro', " +
                "'Pase y devolución entre los jugadores X1 y X3. " +
                "X2 realizará un desmarque de ruptura en el momento en el que X1 realice un pase elevado. " +
                "X2 optará por el disparo directo ó bien por realizar un control previo.', " +
                "'Pase, Tiro', 'Menos de 8 años', 'Media', '15 minutos', 'Pivotes, 1 balón, 1 portería, 3-20 jugadores', " +
                R.drawable.entrenamiento_pared_pase_en_profundidad_tiro + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_pared_pase_en_profundidad_tiro + "')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 8 a 11 años.
     */
    public static void insertarEntrenamientosDe8A11Años() {
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Realiza la pared y chuta', " +
                "'Sucesión de pases entre 4 jugadores en la que se realiza una acción de pared o regate y se culmina con tiro. " +
                "x1 realiza un pase y devolución con x4, posteriormente pase a x2. " +
                "x2 pasa a x3. " +
                "x3 conduce y realiza una acción de pared con x2 o bien regatea por el otro lado la oposición de x4. " +
                "x3 finaliza la acción con un tiro a puerta.', " +
                "'Pase, Tiro, Regate', '8 a 11 años', 'Máxima', '15 minutos', 'Pivotes, 1 balón, 1 portería, 4-24 jugadores', " +
                R.drawable.entrenamiento_realiza_la_pared_chuta + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_realiza_la_pared_chuta + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Las 4 esquinas', " +
                "'El juego de las 4 esquinas. " +
                "A la voz del entrenador todos los jugadores cambiarán de pivotes. " +
                "4 jugadores siempre quedarán fuera.', " +
                "'Calentamiento, Velocidad', '8 a 11 años', 'Baja', '10 minutos', 'Pivotes, 12-20 jugadores', " +
                R.drawable.entrenamiento_las_4_esquinas + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_las_4_esquinas + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Maniobra y pase', " +
                "'Se delimitan dos cuadros con conos(uno más pequeño en el interior del ótro). " +
                "Dos jugadores se sitúan en paralelo fuera del recuadro grande y 2 centrocampistas se sitúan en el interior del pequeño. " +
                "El objetivo que persegirán los centrocampistas será combinar con el jugador del lado contrario al que recibió el balón', " +
                "'Pase, Orientación', '8 a 11 años', 'Media', '15 minutos', 'Pivotes, Petos, 1 balón, 3-24 jugadores', " +
                R.drawable.entrenamiento_maniobra_pase + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_maniobra_pase + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Salto y parada', " +
                "'Se sitúan 3 conos separados 3 metros entre si y el portero se sitúa en uno de los extremos. " +
                "El portero deberá desplazarse lateralmente hasta el cono del medio y cuando le tiren el balón elevarse por encima de éste e intentar blocar el balón. " +
                "A continuación se levanta y realiza la misma acción en el mismo sentido', " +
                "'Porteros', '8 a 11 años', 'Media', '10 minutos', 'Pivotes, 1 balón, 1 jugador(Portero)', " +
                R.drawable.entrenamiento_salto_parada + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_salto_parada + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Saltos de vallas y finalización', " +
                "'El delantero que finalizará la acción sale en sprint desde el borde del área y salta con los pies juntos por encima de las vallas. " +
                "Tras superar las vallas gira alrededor del cono y corre en dirección a portería en busca del pase elevado que le envía su compañero. " +
                "Tras finalizar la acción se intercambian las posiciones', " +
                "'Circuitos, Tiro', '8 a 11 años, Más de 18 años', 'Máxima', '15 minutos', 'Pivotes, Vallas, 1 balón, 1 portería, 2-24 jugadores', " +
                R.drawable.entrenamiento_saltos_vallas_finalizacion + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_saltos_vallas_finalizacion + "')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 11 a 14 años.
     */
    public static void insertarEntrenamientosDe11A14Años() {
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Defensa en inferioridad con relevo', " +
                "'Se delimita un terreno de juego en forma de cuadro. " +
                "Dentro se sitúan 3 atacantes contra 2 defensores. " +
                "Los defensores deben realizar 5 recuperaciones de balón para pasarselos a los atacantes. " +
                "Cada vez que recuperan un balón o provocan una pérdida uno de los defensores se relevará con el tercer compañero que se encuentra fuera del cuadro descansando', " +
                "'Defensa', '11 a 14 años', 'Media', '20 minutos', 'Pivotes, Petos, 1 balón, 6-24 jugadores', " +
                R.drawable.entrenamiento_defensa_en_inferioridad_relevos + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_defensa_en_inferioridad_relevos + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Circuito técnico', " +
                "'El portero deberá parar diferentes tipos de tiros a portería desde distintos ángulos. " +
                "1-Balón colgado al área. " +
                "2- Realizar una voltereta y detener un tiro desde el vértice del área. " +
                "3-Golpeo frontal. " +
                "4-Golpeo frontal desde más lejos. " +
                "5-Voltereta y detener un tiro desde el otro vértice. " +
                "6-Balón colgado', " +
                "'Porteros', '11 a 14 años', 'Alta', '10 minutos', 'Pivotes, 6 balones, 1 portería, 6 jugadores, 1 portero', " +
                R.drawable.entrenamiento_circuito_tecnico + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_circuito_tecnico + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Saque de banda 2', " +
                "'Saque de banda a los pies de X1 ante su movimiento de apoyo. " +
                "X1 devuelve el balón raso al sacador quien controla y realiza un pase en profundidad hacia el desmarque de X2. " +
                "X2 finaliza la acción con disparo a puerta', " +
                "'Saque de banda', '11 a 14 años, Más de 18 años', 'Alta', '15 minutos', '1 balón, 1 portería, 3-20 jugadores', " +
                R.drawable.entrenamiento_saque_de_banda_2 + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_saque_de_banda_2 + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Juego estrategia de córner', " +
                "'Se divide a la plantilla en 3 equipos y se sitúan 4 jugadores para sacar córners. " +
                "En cada córner juegan un equipo defensor contra un equipo atacante. " +
                "Si se consigue gol se sigue atacando en la otra portería, si es el equipo defensor quien logra despejar, éste será quien pase a atacar. " +
                "Cada vez se saca de una esquina diferente. " +
                "Se van sumando los goles conseguidos por cada equipo', " +
                "'Corners', '11 a 14 años, Más de 18 años', 'Media', '25 minutos', 'Petos, 4 balones, 2 porterías, 13-24 jugadores', " +
                R.drawable.entrenamiento_juego_estrategia_de_corner + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_juego_estrategia_de_corner + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Partido 6 porterías', " +
                "'Dividir a la plantilla en 2 equipos. " +
                "Cada equipo defiende-ataca 3 porterías pequeñas situadas a lo largo de la línea de fondo. " +
                "El gol se conseguirá introduciendo el balón en cualquiera de las 3 porterías', " +
                "'Global', '11 a 14 años', 'Media', '35 minutos', 'Pivotes, Petos, 1 balón, 6 porterías, 12-20 jugadores', " +
                R.drawable.entrenamiento_partido_6_porterias + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_partido_6_porterias + "')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de 14 a 18 años.
     */
    public static void insertarEntrenamientosDe14A18Años() {
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Defender el triángulo', " +
                "'Se delimita una zona triangular en el terreno marcada mediante conos. " +
                "El jugador defensor deberá defender las tres porterías resultantes pudiendo para ello atravesar el triángulo por el interior. " +
                "2 jugadores atacantes a través de combinaciones, conducciones... intentarán penetrar dentro del triángulo con balón. " +
                "Posteriormente se cambian las funciones', " +
                "'Defensa', '14 a 18 años', 'Alta', '20 minutos', 'Pivotes, Petos, 1 balón, 3-24 jugadores', " +
                R.drawable.entrenamiento_defender_el_triangulo + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_defender_el_triangulo + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Dinámica de cambios de orientación', " +
                "'Se divide el terreno de juego en 3 zonas (2 bandas y zona central). " +
                "El jugador situado en la zona central realiza una combinación corta con una de las bandas y efectúa un cambio de orientación en largo al compañero situado en la otra banda. " +
                "Los jugadores de banda tras realizar la combinación en corto realizan un sprint hasta la otra zona de campo de su propia banda', " +
                "'Orientación, Pase', '14 a 18 años', 'Media', '20 minutos', 'Pivotes, 2 balones, 6-24 jugadores', " +
                R.drawable.entrenamiento_dinamica_de_cambios_de_orientacion + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_dinamica_de_cambios_de_orientacion + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Velocidad de reacción, reflejos y lateralidad', " +
                "'El portero abre con la mano a un lateral. " +
                "Este da un pase al punto de penalti. " +
                "Un segundo jugador remata de cerca', " +
                "'Porteros, Tiro, Pase', '14 a 18 años', 'Media', '10 minutos', '1 balón, 1 portería, 3 jugadores, 1 portero', " +
                R.drawable.entrenamiento_velocidad_de_reaccion_reflejos_lateralidad + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_velocidad_de_reaccion_reflejos_lateralidad + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Finalización desde fuera del área', " +
                "'Cambio de orientación mediante circulación de balón entre tres centrocampistas. " +
                "El medio centro recibe el balón de un medio de banda y tras apoyarse en el compañero de la otra banda realiza un cambio de orientación al desmarque realizado por su compañero. " +
                "El medio que inició la jugada realiza una dejada hacia atrás para que el medio centro finalice con tiro lejano la acción', " +
                "'Pase, Tiro', '14 a 18 años', 'Media', '25 minutos', 'Pivotes, 1 balón, 1 portería, 3-24 jugadores', " +
                R.drawable.entrenamiento_finalizacion_desde_fuera_del_area + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_finalizacion_desde_fuera_del_area + "')");
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video)" +
                " VALUES ('Superioridad 2x1 y finalización por banda', " +
                "'Se delimitan dos cuadros en banda donde se juegan posesiones 2x1 apoyados por un medio centro que sirve de enlace entre ambas. " +
                "Una vez que se consiguen 3 pases en cada una de éstas se puede buscar finalización de jugada mediante acción de centro por banda con incorporación al remate 2x1. " +
                "Si se consigue gol siguen defendiendo los mismos jugadores, sino se rotan las posiciones', " +
                "'Superioridad', '14 a 18 años, Más de 18 años', 'Alta', '25 minutos', 'Pivotes, Petos, 1 balón, 1 porterías, 10-24 jugadores', " +
                R.drawable.entrenamiento_superioridad_2x1_finalizacion_por_banda + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_superioridad_2x1_finalizacion_por_banda + "')");
    }

    /**
     * Inserta en la BD los entrenamientos de la categoría de edad de más de 18 años.
     */
    public static void insertarEntrenamientosDeMas18Años() {
        MainActivity.database.execSQL("INSERT INTO entrenamientos (nombre, descripcion, tipoEjercicio, categoriaEdad, dificultad, duracion, material, imagen, video) " +
                "VALUES ('Juego de cabeza', " +
                "'Consiste en meter gol de cabeza. " +
                "No se pueden utilizar las manos. " +
                "Es una competición de 2 contra 2. " +
                "Cada pareja hace una vez de defensores y otra de atacantes', " +
                "'Cabeza, Pase, Velocida', 'Más de 18 años', 'Alta', '15 minutos', 'Pivotes, Petos, 1 balón, 4-20 jugadores', " +
                R.drawable.entrenamiento_juego_de_cabeza + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.entrenamiento_juego_de_cabeza + "')");
        // Los demas entrenamientos de esta edad son tambien de las otras edades
    }
}
