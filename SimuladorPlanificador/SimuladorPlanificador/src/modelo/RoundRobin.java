package modelo;
import java.util.LinkedList;
import java.util.Queue;


public class RoundRobin {

    private int quantum;              // Tiempo de quantum para Round Robin
    private Queue<proceso> colaProcesos; // Cola de procesos a ejecutar

      // Constructor
      public RoundRobin(int quantum) {
        this.quantum = quantum;
        this.colaProcesos = new LinkedList<>();
    }

    // Agregar un proceso a la cola
    public void agregarProceso(proceso proceso) {
        colaProcesos.add(proceso);
    }

    // Ejecutar los procesos con Round Robin
    public void ejecutar() {
        System.out.println("Ejecutando Round Robin con quantum " + quantum);
        while (!colaProcesos.isEmpty()) {
            proceso proceso = colaProcesos.poll();
            System.out.println("Ejecutando " + proceso);
            // Simulación de ejecución del proceso (aquí puedes agregar la lógica para reducir el tiempo de ejecución)
        }
    }

    
}
