import java.util.*;

class Boleto {
    String nombre;
    int tiempoEjecucion;

    Boleto(String nombre, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Método para crear una copia del boleto con su tiempo original
    public Boleto copiar() {
        return new Boleto(this.nombre, this.tiempoEjecucion);
    }
}

public class BoletoDeLoteria {

    // Planificación Apropiativa (Round Robin)
    public static void planificacionApropiativa(List<Boleto> boletos) {
        Queue<Boleto> cola = new LinkedList<>(boletos);
        int tiempoTotal = 0;

        System.out.println("=== Sorteo Apropiativo ===");

        while (!cola.isEmpty()) {
            Boleto boleto = cola.poll();
            while (boleto.tiempoEjecucion > 0) {
                System.out.println("Ejecutando: " + boleto.nombre + " por 1 unidad de tiempo");
                boleto.tiempoEjecucion--;
                tiempoTotal++;
            }
            System.out.println("Boleto " + boleto.nombre + " ha sido sorteado.");
        }

        System.out.println("Todos los boletos han sido sorteados en " + tiempoTotal + " unidades de tiempo.");
    }

    // Planificación No Apropiativa (First Come First Served)
    public static void planificacionNoApropiativa(List<Boleto> boletos) {
        int tiempoTotal = 0;

        System.out.println("=== Sorteo No Apropiativo ===");

        for (Boleto boleto : boletos) {
            System.out.println("Ejecutando: " + boleto.nombre + " por " + boleto.tiempoEjecucion + " unidades de tiempo");
            tiempoTotal += boleto.tiempoEjecucion;
            System.out.println("Boleto " + boleto.nombre + " ha sido sorteado.");
        }

        System.out.println("Todos los boletos han sido sorteados en " + tiempoTotal + " unidades de tiempo.");
    }

    // Planificación Apropiativa seguida de No Apropiativa
    public static void planificacionCombinada(List<Boleto> boletos) {
        // Guardamos una copia del tiempo de ejecución original de cada boleto
        List<Boleto> boletosCopia = new ArrayList<>();
        for (Boleto b : boletos) {
            boletosCopia.add(b.copiar());
        }

        System.out.println("=== Sorteo Apropiativo y No Apropiativo ===");

        // Primero, ejecutamos la planificación apropiativa
        planificacionApropiativa(boletos);

        // Restauramos los tiempos de ejecución originales de los boletos
        for (int i = 0; i < boletos.size(); i++) {
            boletos.get(i).tiempoEjecucion = boletosCopia.get(i).tiempoEjecucion;
        }

        // Luego, ejecutamos la planificación no apropiativa
        planificacionNoApropiativa(boletos);
    }

    public static void main(String[] args) {
        // Crear los boletos
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("Boleto 101", 9));
        boletos.add(new Boleto("Boleto 102", 15));
        boletos.add(new Boleto("Boleto 103", 6));
        boletos.add(new Boleto("Boleto 104", 4));

        Scanner scanner = new Scanner(System.in);

        // Preguntar al usuario qué tipo de sorteo desea
        System.out.println("Elige el tipo de sorteo:");
        System.out.println("1. Apropiativo (Round Robin)");
        System.out.println("2. No Apropiativo (First Come First Served)");
        System.out.println("3. Apropiativo seguido de No Apropiativo");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            planificacionApropiativa(boletos); // Ejecuta sorteo apropiativo
        } else if (opcion == 2) {
            planificacionNoApropiativa(boletos); // Ejecuta sorteo no apropiativo
        } else if (opcion == 3) {
            planificacionCombinada(boletos); // Ejecuta sorteo combinado
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}
