package chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.table.DefaultTableModel;

public class ChatServer implements Runnable {
    private DefaultTableModel tableModel;

    public ChatServer(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(56789);

            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String mensaje = (String) ois.readObject();

                // Añadir el mensaje recibido a la tabla
                tableModel.addRow(new Object[]{"usuario1", getNextMessageId(), mensaje, getCurrentDateTime()});
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int getNextMessageId() {
        // Lógica para obtener el próximo ID de mensaje
        // Por simplicidad, aquí utilizaremos un contador
        return tableModel.getRowCount() + 1;
    }

    private String getCurrentDateTime() {
        // Lógica para obtener la fecha y hora actual
        // Por simplicidad, aquí utilizaremos la fecha y hora del sistema
        return java.time.LocalDateTime.now().toString();
    }
}
