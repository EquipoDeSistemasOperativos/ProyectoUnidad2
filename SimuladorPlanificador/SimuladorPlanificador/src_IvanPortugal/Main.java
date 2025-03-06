import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Proceso> procesos = new ArrayList<>();

        System.out.print("Ingrese el número de procesos: ");
        int numProcesos = scanner.nextInt();
        
        for (int i = 1; i <= numProcesos; i++) {
            System.out.println("Ingrese los datos para el proceso " + i + ":");
            System.out.print("Tiempo de ejecución: ");
            int tiempo = scanner.nextInt();
            System.out.print("Prioridad (menor número = mayor prioridad): ");
            int prioridad = scanner.nextInt();
            procesos.add(new Proceso(i, tiempo, prioridad));
        }
        
        Planificador planificador = new Planificador();
        planificador.planificarConColasPrioridad(procesos);
        System.out.println();
        planificador.planificarSJF(procesos);
        
        scanner.close();
    }
}