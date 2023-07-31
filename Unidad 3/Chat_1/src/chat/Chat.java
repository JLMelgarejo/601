package chat;

import javax.swing.SwingUtilities;

public class Chat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear un nuevo hilo para ejecutar el programa Enviar
            Thread enviarThread = new Thread(() -> {
                Enviar enviar = new Enviar();
                enviar.setLocationRelativeTo(null); // Centrar la ventana de Enviar
                enviar.setVisible(true); // Mostrar la ventana de Enviar
            });

            // Crear un nuevo hilo para ejecutar el programa Enviar1
            Thread enviar1Thread = new Thread(() -> {
                Enviar1 enviar1 = new Enviar1();
                enviar1.setLocationRelativeTo(null); // Centrar la ventana de Enviar1
                enviar1.setVisible(true); // Mostrar la ventana de Enviar1
            });

            // Iniciar ambos hilos para ejecutar los programas Enviar y Enviar1
            enviarThread.start();
            enviar1Thread.start();
        });
    }
}
