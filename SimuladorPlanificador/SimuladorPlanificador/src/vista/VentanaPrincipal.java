package vista;

import javax.swing.*;
import java.awt.*;
import controlador.Controlador; // Importamos el controlador

public class VentanaPrincipal extends JFrame {
    
    // Constructor de la ventana principal
    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Simulador de Planificador de Procesos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Etiqueta en la parte superior
        JLabel label = new JLabel("Seleccione un algoritmo:", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        // Botón para ejecutar Round Robin
        JButton botonRoundRobin = new JButton("Ejecutar Round Robin");
        add(botonRoundRobin, BorderLayout.CENTER);

        // Acción del botón Round Robin
        botonRoundRobin.addActionListener(e -> {
            // Aquí llamamos al controlador para ejecutar el algoritmo
            Controlador.ejecutarRoundRobin();
        });

        // Hacer visible la ventana
        setVisible(true);
    }
}
