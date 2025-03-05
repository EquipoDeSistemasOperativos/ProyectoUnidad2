package modelo;

public class proceso {

    private int id;                     //id del proceso
    private int tiempodellegada;        //Tiempo de llegada del proceso
    private int duracion;               // Duración o tiempo de ejecución del proceso
    private int prioridad;              // Prioridad del proceso (si aplica)
    
    public proceso(int id, int tiempodellegada, int duracion, int prioridad) {
        this.id = id;
        this.tiempodellegada = tiempodellegada;
        this.duracion = duracion;
        this.prioridad = prioridad;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTiempodellegada() {
        return tiempodellegada;
    }
    public void setTiempodellegada(int tiempodellegada) {
        this.tiempodellegada = tiempodellegada;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    // Representación en texto del proceso
    @Override
    public String toString() {
     return "Proceso " + id + " [T=" + tiempodellegada + ", D=" + duracion + ", P=" + prioridad + "]";
    }

    
}