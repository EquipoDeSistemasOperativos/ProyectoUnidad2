import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Planificador {
    private PriorityQueue<Proceso> colaPrioridad;
    private PriorityQueue<Proceso> colaSJF;
    private List<Proceso> procesosTerminados;

    public Planificador() {
        this.colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Proceso::getPrioridad));
        this.colaSJF = new PriorityQueue<>(Comparator.comparingInt(Proceso::getDuracion));
        this.procesosTerminados = new ArrayList<>();
    }

    public void agregarProceso(Proceso proceso) {
        colaPrioridad.offer(proceso);
        colaSJF.offer(proceso);
    }

    public void ejecutarPrioridad() {
        while (!colaPrioridad.isEmpty()) {
            Proceso proceso = colaPrioridad.poll();
            System.out.println("Ejecutando (Prioridad): " + proceso);
            proceso.reducirTiempoRestante(proceso.getDuracion());
            proceso.setEstado("Finalizado");
            procesosTerminados.add(proceso);
        }
    }

    public void ejecutarSJF() {
        while (!colaSJF.isEmpty()) {
            Proceso proceso = colaSJF.poll();
            System.out.println("Ejecutando (SJF): " + proceso);
            proceso.reducirTiempoRestante(proceso.getDuracion());
            proceso.setEstado("Finalizado");
            procesosTerminados.add(proceso);
        }
    }

    public void mostrarProcesosTerminados() {
        System.out.println("Procesos Finalizados:");
        for (Proceso p : procesosTerminados) {
            System.out.println(p);
        }
    }
    
}
