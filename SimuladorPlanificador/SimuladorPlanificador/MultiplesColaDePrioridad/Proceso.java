public class Proceso {
    private int id;
    private int tiempoLlegada;
    private int duracion;
    private int prioridad;
    private int tiempoRestante;
    private String estado;

    public Proceso(int id, int tiempoLlegada, int duracion, int prioridad) {
        this.id = id;
        this.tiempoLlegada = tiempoLlegada;
        this.duracion = duracion;
        this.prioridad = prioridad;
        this.tiempoRestante = duracion;
        this.estado = "Nuevo";
    }

    public int getId() {
        return id;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void reducirTiempoRestante(int tiempo) {
        this.tiempoRestante -= tiempo;
        if (this.tiempoRestante <= 0) {
            this.estado = "Finalizado";
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proceso " + id + " | Llegada: " + tiempoLlegada + " | Duración: " + duracion + 
               " | Prioridad: " + prioridad + " | Restante: " + tiempoRestante + " | Estado: " + estado;
    }
}
