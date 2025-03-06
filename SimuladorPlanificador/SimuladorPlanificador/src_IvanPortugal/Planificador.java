import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Planificador {
    //  colas de prioridad con TreeMap y LinkedList
    public void planificadorConColasPrioridad (List<Proceso>procesos){
        Map<Integer, Queue<Proceso>> colas = new TreeMap<>();

        for(Proceso p : Procesos{
            colas.putIfAbsent(p.prioridad, new LinkedList<>());
            colas.get(p.prioridad).offer(p);
        }

        System.out.println("\nEjecución con Múltiples Colas de Prioridad:");
        for (int prioridad : colas.keySet()) {
            while (!colas.get(prioridad).isEmpty()) {
                Proceso p = colas.get(prioridad).poll();
                System.out.println("Proceso " + p.id + " con prioridad " + p.prioridad + " ejecutándose por " + p.tiempoEjecucion + " unidades de tiempo.");
            }
        }
    }
    // Proceso Más Corto Primero (SJF) con PriorityQueue
    public void planificarSJF(List<Proceso> procesos) {
        PriorityQueue<Proceso> colaSJF = new PriorityQueue<>(Comparator.comparingInt(p -> p.tiempoEjecucion));
        colaSJF.addAll(procesos);
        
        System.out.println("\nEjecución con Proceso Más Corto Primero (SJF):");
        while (!colaSJF.isEmpty()) {
            Proceso p = colaSJF.poll();
            System.out.println("Proceso " + p.id + " con tiempo de ejecución " + p.tiempoEjecucion + " ejecutándose...");
        }
    }


    
}