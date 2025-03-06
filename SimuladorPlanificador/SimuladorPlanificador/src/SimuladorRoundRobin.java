import java.util.*;

public class SimuladorRoundRobin {
    private static final int TIME_QUANTUM = 4;  // Tiempo de quantum

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Proceso> procesos = new ArrayList<>();

        // Leer los datos de los procesos
        System.out.println("Introduce el número de procesos:");
        int numProcesos = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        // Leer cada proceso
        for (int i = 0; i < numProcesos; i++) {
            System.out.println("Introduce el nombre del proceso #" + (i + 1) + ":");
            String nombre = scanner.nextLine();
            System.out.println("Introduce el tiempo de llegada del proceso #" + (i + 1) + ":");
            int tiempoLlegada = scanner.nextInt();
            System.out.println("Introduce el tiempo de ejecución del proceso #" + (i + 1) + ":");
            int tiempoEjecucion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            procesos.add(new Proceso(nombre, tiempoLlegada, tiempoEjecucion));
        }

        // Ordenar los procesos por tiempo de llegada
        procesos.sort(Comparator.comparingInt(p -> p.tiempoLlegada));

        // Ejecutar el algoritmo Round Robin
        ejecutarRoundRobin(procesos);
    }

    public static void ejecutarRoundRobin(List<Proceso> procesos) {
        int tiempoTotal = 0;
        Queue<Proceso> cola = new LinkedList<>();
        List<String> secuenciaEjecucion = new ArrayList<>();
        List<String> tablaDeControl = new ArrayList<>();

        // Añadir procesos con tiempo de llegada <= tiempoTotal
        for (Proceso p : procesos) {
            if (p.tiempoLlegada <= tiempoTotal) {
                cola.add(p);
            }
        }

        // Ejecutar el algoritmo Round Robin
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();

            // Ejecutar el proceso por un "quantum"
            int tiempoEjecutado = Math.min(proceso.tiempoRestante, TIME_QUANTUM);
            proceso.tiempoRestante -= tiempoEjecutado;
            tiempoTotal += tiempoEjecutado;

            // Registrar la ejecución
            secuenciaEjecucion.add(proceso.nombre + " (" + tiempoEjecutado + " unidades)");
            tablaDeControl.add("Proceso: " + proceso.nombre + " | Tiempo Total: " + tiempoTotal);

            // Si el proceso no ha terminado, volver a agregarlo a la cola
            if (proceso.tiempoRestante > 0) {
                cola.add(proceso);
            }

            // Añadir nuevos procesos que hayan llegado durante la ejecución
            for (Proceso p : procesos) {
                if (p.tiempoLlegada <= tiempoTotal && !cola.contains(p) && p.tiempoRestante > 0) {
                    cola.add(p);
                }
            }
        }

        // Mostrar resultados
        System.out.println("\nSecuencia de Ejecución:");
        for (String ejec : secuenciaEjecucion) {
            System.out.println(ejec);
        }

        System.out.println("\nTabla de Control de Procesos:");
        for (String control : tablaDeControl) {
            System.out.println(control);
        }
    }
}
