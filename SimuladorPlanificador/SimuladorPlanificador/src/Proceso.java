public class Proceso {
    String nombre;
    int tiempoLlegada;
    int tiempoEjecucion;
    int tiempoRestante;

    public Proceso(String nombre, int tiempoLlegada, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Proceso: " + nombre + ", Llegada: " + tiempoLlegada + ", Ejecución: " + tiempoEjecucion;
    }
}


