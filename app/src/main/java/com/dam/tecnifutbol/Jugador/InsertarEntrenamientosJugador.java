package com.dam.tecnifutbol.Jugador;

import com.dam.tecnifutbol.MainActivity;
import com.dam.tecnifutbol.R;

public class InsertarEntrenamientosJugador {
    public static void insertarEntrenamientosEnGym() {
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Sentadilla Olímpica', " +
                        "'La sentadilla olímpica es un ejercicio que fortalece la parte inferior del cuerpo y el núcleo, dirigido a múltiples grupos musculares como cuádriceps, isquiotibiales y glúteos. Adecuado para todos los niveles de condición física, ofrece mejoras en la fuerza, flexibilidad y aptitud funcional para actividades diarias y deportivas.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'Cada repetición debe ser explosiva', " +
                        R.drawable.sentadilla_olimpica + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.sentadilla_olimpica + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Buenos dias', " +
                        "'El ejercicio buenos días implica una carga excéntrica significativa, lo que implica una activación intensa de los músculos durante la fase de estiramiento. Esta acción ayuda a reducir el riesgo de lesiones en los isquiotibiales, haciendo que el ejercicio sea efectivo para prevenir tales lesiones.', "+
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        R.drawable.buenos_dias + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.buenos_dias + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Flexiones con lastre', " +
                        "'Las flexiones lastradas son una variación avanzada de las flexiones clásicas en el suelo, utilizadas para fortalecer y aumentar el tamaño de los músculos superiores del cuerpo. Implican agregar peso adicional al cuerpo durante el ejercicio, lo que las hace ideales para deportistas experimentados en flexiones convencionales.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        R.drawable.flexion_lastre + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.flexiones_lastradas + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Remo con barra', " +
                        "'El remo es un ejercicio de tirón que trabaja la parte media de la espalda y los músculos de los brazos. Además de fortalecer y aumentar el tamaño muscular en esa área, también mejora la estabilidad del hombro y ayuda a mantener la alineación adecuada de la articulación.', " +
                        "'GYM', " +
                        "'3 series x 5 repeticiones', " +
                        "'', " +
                        R.drawable.remo_barra + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.remo_barra + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Hiperextensiones de tronco', " +
                        "'Las hiperextensiones de tronco son un ejercicio para fortalecer la espalda baja y los glúteos. Se realizan inclinándose hacia adelante desde la cintura mientras se está acostado boca abajo en una máquina especializada, y luego volviendo a la posición inicial. Ayudan a fortalecer la musculatura de la espalda baja y a mejorar la estabilidad de la columna vertebral.'," +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'', " +
                        R.drawable.hiperextension_tronco + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.hiperextension_tronco + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Superseries de curl de bíceps y extensión de tríceps', " +
                        "'Las superseries de curl de bíceps y extensión de tríceps son una técnica de entrenamiento donde se realizan dos ejercicios consecutivos para grupos musculares opuestos sin descanso entre ellos. Esto ayuda a maximizar el tiempo de trabajo muscular y aumentar la intensidad del entrenamiento para mejorar la fuerza y el desarrollo de los brazos de manera eficiente.', " +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'Consiste en hacer curl de biceps con polea baja y al acabar cambiar a polea alta para hacer las extensiones de tricps.', " +
                        R.drawable.curl_biceps_extension_triceps + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.curl_biceps_extension_triceps + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                        "VALUES (" +
                        "'Abdominales', " +
                        "'El ejercicio de abdominales se centra en fortalecer los músculos del abdomen para tonificar y definir esta área. Incluye una variedad de movimientos como crunches y planchas, que se pueden realizar en el suelo o con equipo especializado. Estos ejercicios mejoran la fuerza del núcleo y promueven una postura saludable.', " +
                        "'GYM', " +
                        "'4 series x 12 repeticiones', " +
                        "'', " +
                        R.drawable.abdominales + ", " +
                        "'android.resource://com.dam.tecnifutbol/" + R.raw.abdominales + "')"
                );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Press Banca', " +
                "'El press banca es un ejercicio de levantamiento de pesas realizado en un banco horizontal con una barra cargada. Se centra en fortalecer los músculos del pecho, hombros y tríceps. El levantador baja la barra hacia el pecho y luego la empuja hacia arriba hasta que los brazos estén completamente extendidos. Es esencial mantener una técnica adecuada para evitar lesiones y maximizar los beneficios. Este ejercicio es fundamental en programas de entrenamiento de fuerza para desarrollar la musculatura superior del cuerpo.', " +
                "'GYM', " +
                "'3 series x 5 repeticiones', " +
                "'', " +
                R.drawable.press_banca + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.press_banca + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Sentadillas búlgaras', " +
                "'Las sentadillas búlgaras son un ejercicio de fuerza para las piernas que se realiza con un pie apoyado en un banco o plataforma y el otro extendido hacia atrás. Se baja el cuerpo doblando la rodilla de la pierna delantera hasta casi tocar el suelo con la rodilla trasera, manteniendo la espalda recta, y luego se vuelve a la posición inicial. Este ejercicio mejora la fuerza, el equilibrio y la estabilidad de las piernas.', " +
                "'GYM', " +
                "'3 series x 5 repeticiones', " +
                "'', " +
                R.drawable.sentadilla_bulgara + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.sentadilla_bulgara + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Peso muerto, agarre de arrancada', " +
                "'El peso muerto con agarre de arrancada es un ejercicio de levantamiento de pesas que fortalece la cadena posterior. Se realiza con una barra en el suelo y un agarre amplio. Levantando la barra con la espalda recta hasta estar de pie, se trabaja la fuerza, potencia y estabilidad en la parte inferior del cuerpo y la espalda. Es fundamental en programas de entrenamiento de fuerza y levantamiento olímpico.', " +
                "'GYM', " +
                "'1 serie x 5 repeticiones', " +
                "'El agarre es más ancho que el convencional, aumentando el recorrido y poniendo más énfasis en glúteos e isquiotibiales', " +
                R.drawable.peso_muerto_agarre_arrancada + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.peso_muerto + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Jalones al pecho', " +
                "'Los jalones al pecho son un ejercicio de fuerza para la espalda y los brazos. Se realizan típicamente en una máquina de polea alta o con una barra fija. El individuo se sienta y tira de la barra hacia abajo hasta que toque el pecho, manteniendo la espalda recta. Es efectivo para desarrollar fuerza y tamaño en la espalda y los brazos.', " +
                "'GYM', " +
                "'3 series x 12 repeticiones', " +
                "'', " +
                R.drawable.jalon_al_pecho + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.jalon_pecho + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Flexiones pliométricas', " +
                "'Las flexiones pliométricas son una versión avanzada de las flexiones tradicionales que incluye un salto explosivo. Comienzas en la posición de flexión tradicional y luego realizas una flexión explosiva para levantar las manos del suelo y permitir que el cuerpo despegue brevemente. Este ejercicio mejora la fuerza explosiva, la potencia y la resistencia, pero requiere precaución debido a su intensidad.', " +
                "'GYM', " +
                "'3 series x 3 repeticiones', " +
                "'', " +
                R.drawable.flexiones_pliometricas + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.flexiones_pliometricas + "')"
        );
    }
    public static void insertarEntrenamientosEnCasa() {
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Saltos en tijera', " +
                "'Los saltos con tijera son un ejercicio que implica saltos laterales alternando las piernas en el aire, similar al movimiento de abrir y cerrar tijeras. Se inicia de pie, se da un salto lateral cruzando una pierna por delante de la otra y se llevan los brazos hacia arriba. Se cambia la posición de las piernas en el aire y se aterriza suavemente, repitiendo el movimiento hacia el otro lado. Este ejercicio fortalece las piernas, los glúteos y los abdominales, y mejora la coordinación y la agilidad. Es ideal para entrenamientos de alta intensidad o como calentamiento dinámico.', " +
                "'CASA', " +
                "'4 series x 20 repeticiones', " +
                "'', " +
                R.drawable.saltos_tijera + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.jumping_jacks + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Mountain climbers', " +
                "'Los mountain climbers son un ejercicio cardiovascular y de tonificación que se realiza en posición de plancha alta. Consiste en llevar alternativamente las rodillas hacia el pecho lo más cerca posible, imitando el movimiento de correr en el lugar. Trabaja los músculos del core, los brazos y las piernas, aumentando la frecuencia cardíaca y mejorando la resistencia cardiovascular. Es una adición eficaz a cualquier rutina de entrenamiento de cuerpo completo o circuito de alta intensidad.', " +
                "'CASA', " +
                "'4 series x 20 repeticiones', " +
                "'', " +
                R.drawable.mountain_climbers + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.mountain_climbers + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Saltos de estrella', " +
                "'Los saltos de estrella son un ejercicio pliométrico explosivo que involucra un salto hacia arriba y hacia los lados con la extensión de las piernas y los brazos en forma de estrella. Trabaja los músculos de las piernas, glúteos y abdominales, mejorando la potencia, coordinación y agilidad. Es ideal como parte de una rutina de alta intensidad o como calentamiento dinámico antes de otros ejercicios.', " +
                "'CASA', " +
                "'4 series x 20 repeticiones', " +
                "'', " +
                R.drawable.saltos_estrella + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.saltos_estrella + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Sentadillas', " +
                "'Las sentadillas son un ejercicio de entrenamiento de fuerza que fortalece los músculos de las piernas, como cuádriceps, glúteos e isquiotibiales. Se realizan flexionando las rodillas y las caderas, manteniendo la espalda recta y el peso en los talones. Es esencial mantener una técnica adecuada para evitar lesiones y maximizar los beneficios. Las sentadillas pueden realizarse con el peso corporal o con resistencia adicional, como barras o mancuernas. Son fundamentales para el desarrollo muscular de las piernas y los glúteos.', " +
                "'CASA', " +
                "'4 series x 15 repeticiones', " +
                "'', " +
                R.drawable.sentadilla + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.sentadillas + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Flexiones de brazos', " +
                "'Las flexiones de brazos, también llamadas push-ups, son un ejercicio que fortalece los músculos del pecho, hombros, tríceps y abdominales. Se realiza desde una posición de plancha alta, bajando el cuerpo hacia el suelo doblando los codos y luego empujando hacia arriba. Es efectivo para mejorar la fuerza y la resistencia muscular en la parte superior del cuerpo y el core. Pueden adaptarse según el nivel de condición física del individuo.', " +
                "'CASA', " +
                "'3 series x 10 repeticiones', " +
                "'', " +
                R.drawable.flexiones + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.flexiones + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Zancadas', " +
                "'Las zancadas son un ejercicio de fuerza que trabaja los músculos de las piernas, incluyendo cuádriceps, glúteos e isquiotibiales. Se realizan dando un paso hacia adelante con una pierna y bajando el cuerpo hasta que ambas rodillas estén dobladas en un ángulo de 90 grados. Luego, se empuja hacia arriba con la pierna delantera para volver a la posición inicial. Pueden realizarse con o sin peso adicional y son efectivas para mejorar la fuerza, estabilidad y equilibrio en las piernas.', " +
                "'CASA', " +
                "'3 series x 12 repeticiones', " +
                "'', " +
                R.drawable.zancadas + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.zancada + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Sprint en el lugar', " +
                "'El sprint en el lugar es un ejercicio cardiovascular de alta intensidad que simula correr en un lugar fijo. Consiste en levantar las rodillas hacia el pecho y mover los brazos rápidamente como si estuvieras corriendo. Es efectivo para aumentar la frecuencia cardíaca, quemar calorías y mejorar la resistencia cardiovascular y la velocidad. Es útil como parte de un entrenamiento de alta intensidad o como calentamiento antes de otros ejercicios.', " +
                "'CASA', " +
                "'4 series x 30 segundos', " +
                "'', " +
                R.drawable.sprint_sitio + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.sprint_sitio + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Plancha con toque de hombro', " +
                "'La plancha con toque de hombro es un ejercicio que fortalece el core y los hombros. Se realiza en posición de plancha alta, levantando una mano para tocar el hombro opuesto y luego alternando con la otra mano. Trabaja los músculos del core, los hombros y los brazos, mejorando la estabilidad y la fuerza del cuerpo.', " +
                "'CASA', " +
                "'3 series x 15 repeticiones', " +
                "'', " +
                R.drawable.plancha + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.plancha_hombro + "')"
        );
        MainActivity.database.execSQL("INSERT INTO entrenamientosJugador (nombre, descripcion, lugar, repeticiones, nota, imagen, video) " +
                "VALUES (" +
                "'Equilibrio en una pierna', " +
                "'El equilibrio en una pierna es un ejercicio que mejora la estabilidad y la fuerza en las piernas y el core. Se realiza levantando una pierna del suelo mientras mantienes la otra ligeramente flexionada. Mantén la postura erguida y evita balancearte durante unos segundos. Cambia de pierna y repite. Puedes aumentar la dificultad cerrando los ojos o usando una superficie inestable. Este ejercicio fortalece los músculos estabilizadores y mejora la coordinación del cuerpo.', " +
                "'CASA', " +
                "'3 series x 40 segundos/pierna', " +
                "'', " +
                R.drawable.equilibrio_una_pierna + ", " +
                "'android.resource://com.dam.tecnifutbol/" + R.raw.equilibrio_pierna + "')"
        );
    }
}
