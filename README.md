# hilos-java

IA (3 puntos) – Readme.md – Explica en qué te ha ayudado la IA. Incluye el código inicial y las mejoras que has obtenido, explicando el proceso que has seguido. La IA nos ha ayudado en la sincronización de los problemas para que la carrera de los robots funcionara de forma eficiente. Este es el código inicial: import java.util.Random;

public class Robot extends Thread { private String nombre; private static boolean carreraTerminada = false;

public Robot(String nombre) {
    this.nombre = nombre;
}

public void run() {
    Random random = new Random();
    int recorrido = 0;
    
    while (!carreraTerminada) {
        int avance = random.nextInt(10) + 1;
        recorrido += avance;
        System.out.println(nombre + " avanzó " + avance + " metros. Recorrido total: " + recorrido);
        
        if (recorrido >= 100) {
            carreraTerminada = true;
            System.out.println(nombre + " ha ganado la carrera");
        }
    }
}

public static void main(String[] args) {
    Robot robotRojo = new Robot("Robot Rojo");
    Robot robotAzul = new Robot("Robot Azul");

    robotRojo.start();
    robotAzul.start();
}
}


Y las mejoras que hemos implementado han sido el método volatile para garantizar que la carrera terminaba y determinaba un ganador, se ha introducido un mensaje que cuando el primer robot llega a la meta el otro robot se detiene ya que la carrera se da como finalizada. Y por último hemos separado el método "run" y hemos añadido el método "robot" para un mejor funcionamiento y manejo del hilo.

Pensamiento crítico (3 puntos) – Readme.md – Ejecuta el programa varias veces, ¿qué pasa y por qué? Al ejecutar el programa varias veces, noté que los resultados son diferentes en cada carrera. Esto se debe al movimiento aleatorio de los robots; cada vez, un robot distinto puede ganar. Esta variabilidad muestra cómo la concurrencia y la aleatoriedad influyen en el resultado, Por lo que no puedes predecir quien gana la carrera.

– Los Robots no se comunican entre ellos, ¿qué problemas pueden surgir al no sincronizarse? Investiga sobre los problemas de comunicación entre hilos y cómo pueden solucionarse. Los hilos en este programa no se comunican entre sí, lo que podría causar una condición de carrera. Sin la variable hayGanador, varios robots podrían intentar ganar al mismo tiempo. Por eso, usamos esta variable para asegurarnos de que solo uno pueda declarar la victoria.

Para que los problemas de sincronización sean mas efectivos hemos usado el metodo volatile, que es de tipo boolean y cuando sea "true" finalice el programa.

– Proporciona tus conclusiones sobre lo que has aprendido en esta actividad y cómo crees que la programación concurrente puede ser útil en el desarrollo de aplicaciones multiplataforma. Esta actividad nos ha enseñado que es muy útil en aplicaciones donde se necesita ejecutar tareas en paralelo, como en servidores o videojuegos. Sin embargo, es esencial gestionar bien la sincronización entre hilos para evitar problemas que podrían afectar el resultado final y generar problemas a los usuarios.
