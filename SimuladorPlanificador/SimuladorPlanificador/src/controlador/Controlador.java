package controlador;
import modelo.proceso;
import modelo.RoundRobin;

public class Controlador {

    // Método para ejecutar el algoritmo Round Robin
    public static void ejecutarRoundRobin() {
        // Crear algunos procesos de ejemplo
        proceso p1 = new proceso(1, 0, 5, 1);
        proceso p2 = new proceso(2, 2, 3, 2);
        proceso p3 = new proceso(3, 4, 4, 3);
        
        // Crear el planificador Round Robin
        RoundRobin rr = new RoundRobin(2); // Quantum de 2
        rr.agregarProceso(p1);
        rr.agregarProceso(p2);
        rr.agregarProceso(p3);
        
        // Ejecutar el planificador
        rr.ejecutar();
    }
    
}
