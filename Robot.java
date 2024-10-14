import java.util.*;

public class Robot extends Thread {
    private String nombre;
    private static volatile boolean carreraTerminada = false;

    public Robot(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        System.out.println(robot(nombre));
    }

    public String robot(String nombre) {
        Random random = new Random();
        int recorrido = 0;
        
        while (!carreraTerminada) {
            int avance = random.nextInt(10) + 1;
            recorrido += avance;
            System.out.println(nombre + " avanzó " + avance + " metros. Recorrido total: " + recorrido);
            
            if (recorrido >= 100 && !carreraTerminada) {
                carreraTerminada = true;
                return nombre + " ha ganado la carrera";
            }
        }

        return nombre + " se detuvo ya que la carrera terminó.";
    }
    
    public static void main(String[] args) {
        Robot robotRojo = new Robot("Robot Rojo");
        Robot robotAzul = new Robot("Robot Azul");

        robotRojo.start();
        robotAzul.start();
    }
}
