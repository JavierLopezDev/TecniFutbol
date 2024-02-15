package com.dam.tecnifutbol.Jugador;

import com.dam.tecnifutbol.MainActivity;

public class InsertarEntrenamientosJugador {
    public static void insertarEntrenamientosEnGym() {
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Sentadilla Olímpica', " +
                        "'La sentadilla olímpica es un ejercicio que fortalece la parte inferior del cuerpo y el núcleo, dirigido a múltiples grupos musculares como cuádriceps, isquiotibiales y glúteos. Adecuado para todos los niveles de condición física, ofrece mejoras en la fuerza, flexibilidad y aptitud funcional para actividades diarias y deportivas.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'Cada repetición debe ser explosiva', " +
                        "a , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Buenos dias', " +
                        "'El ejercicio buenos días implica una carga excéntrica significativa, lo que implica una activación intensa de los músculos durante la fase de estiramiento. Esta acción ayuda a reducir el riesgo de lesiones en los isquiotibiales, haciendo que el ejercicio sea efectivo para prevenir tales lesiones.', "+
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        "img , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Flexiones con lastre', " +
                        "'Las flexiones lastradas son una variación avanzada de las flexiones clásicas en el suelo, utilizadas para fortalecer y aumentar el tamaño de los músculos superiores del cuerpo. Implican agregar peso adicional al cuerpo durante el ejercicio, lo que las hace ideales para deportistas experimentados en flexiones convencionales.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        "img , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Remo con barra', " +
                        "'El remo es un ejercicio de tirón que trabaja la parte media de la espalda y los músculos de los brazos. Además de fortalecer y aumentar el tamaño muscular en esa área, también mejora la estabilidad del hombro y ayuda a mantener la alineación adecuada de la articulación.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        "img , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Hiperextensiones de tronco', " +
                        "'Las hiperextensiones de tronco son un ejercicio para fortalecer la espalda baja y los glúteos. Se realizan inclinándose hacia adelante desde la cintura mientras se está acostado boca abajo en una máquina especializada, y luego volviendo a la posición inicial. Ayudan a fortalecer la musculatura de la espalda baja y a mejorar la estabilidad de la columna vertebral.'," +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'', " +
                        "img , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Superseries de curl de bíceps y extensión de tríceps', " +
                        "'Las superseries de curl de bíceps y extensión de tríceps son una técnica de entrenamiento donde se realizan dos ejercicios consecutivos para grupos musculares opuestos sin descanso entre ellos. Esto ayuda a maximizar el tiempo de trabajo muscular y aumentar la intensidad del entrenamiento para mejorar la fuerza y el desarrollo de los brazos de manera eficiente.', " +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'Consiste en hacer curl de biceps con polea baja y al acabar cambiar a polea alta para hacer las extensiones de tricps.', " +
                        "img , " +
                        "'video'" +")"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Abdominales', " +
                        "'El ejercicio de abdominales se centra en fortalecer los músculos del abdomen para tonificar y definir esta área. Incluye una variedad de movimientos como crunches y planchas, que se pueden realizar en el suelo o con equipo especializado. Estos ejercicios mejoran la fuerza del núcleo y promueven una postura saludable.', " +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'', " +
                        "img , " +
                        "'video'" +")"
                );

    }
}
