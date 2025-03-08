import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        Planificador planificador = new Planificador();

        System.out.print("Ingrese el número de procesos: ");
        int numProcesos = Scanner.nextInt();

        for (int i = 0; i < numProcesos; i++) {
            System.out.println("Ingrese los datos del proceso " + (i + 1) + ":");
            System.out.print("Tiempo de llegada: ");
            int tiempoLlegada = Scanner.nextInt();
            System.out.print("Duración: ");
            int duracion = Scanner.nextInt();
            System.out.print("Prioridad: ");
            int prioridad = Scanner.nextInt();

            planificador.agregarProceso(new Proceso(i + 1, tiempoLlegada, duracion, prioridad));
        }

        System.out.println("\nEjecutando procesos con planificación por prioridad:");
        planificador.ejecutarPrioridad();
        planificador.mostrarProcesosTerminados();

        System.out.println("\nEjecutando procesos con planificación SJF:");
        planificador.ejecutarSJF();
        planificador.mostrarProcesosTerminados();
    }
}
