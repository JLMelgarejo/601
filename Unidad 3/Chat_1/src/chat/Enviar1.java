package chat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Enviar1 extends JFrame implements ActionListener, KeyListener {
    private JTextField textField;
    private JButton enviarButton;
    private JTextField dateTextField;
    private JButton searchButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Conectar conectar;

    public Enviar1() {
        conectar = new Conectar();
        tableModel = new DefaultTableModel();
        initializeGUI();
        updateTable(); // Mostrar todos los registros al iniciar el programa

        // Iniciar el servidor para recibir mensajes
        new Thread(new ChatServer(tableModel)).start();
    }

    private void initializeGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Usuario2");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel para el campo de envío de mensajes
        JPanel sendPanel = new JPanel();
        sendPanel.setLayout(new FlowLayout());
        textField = new JTextField(30);
        textField.addKeyListener(this);
        sendPanel.add(textField);

        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(this);
        sendPanel.add(enviarButton);

        add(sendPanel, BorderLayout.NORTH);

        // Panel para el campo de búsqueda por fecha
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        dateTextField = new JTextField(10);
        dateTextField.addKeyListener(this);
        searchPanel.add(dateTextField);

        searchButton = new JButton("Buscar");
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.SOUTH);

        // Tabla para el historial de mensajes
        tableModel.addColumn("Usuario");
        tableModel.addColumn("ID Mensaje");
        tableModel.addColumn("Mensaje");
        tableModel.addColumn("Fecha");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void enviarMensaje() {
        String mensaje = textField.getText();
        if (!mensaje.isEmpty()) {
            try {
                Connection con = conectar.conexion();
                String sql = "INSERT INTO mensaje (usuario, mensaje) VALUES (?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, "usuario1"); // Valor fijo "usuario1"
                statement.setString(2, mensaje);
                statement.executeUpdate();
                con.close();
                System.out.println("Usuario2 dice: " + mensaje);

                // Enviar el mensaje a través de sockets
                Socket socket = new Socket("localhost", 12346);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(mensaje);
                socket.close();

                textField.setText("");
                updateTable(); // Actualizar tabla en Historial
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateTable() {
        tableModel.setRowCount(0); // Clear the existing rows
        try {
            Connection con = conectar.conexion();
            String sql;
            PreparedStatement statement;
            ResultSet resultSet;

            if (dateTextField.getText().isEmpty()) {
                // Consulta sin filtro de fecha
                sql = "SELECT id_mensaje, mensaje, fecha, usuario FROM mensaje";
                statement = con.prepareStatement(sql);
            } else {
                // Consulta con filtro de fecha
                sql = "SELECT id_mensaje, mensaje, fecha, usuario FROM mensaje WHERE fecha = ?";
                statement = con.prepareStatement(sql);
                statement.setString(1, dateTextField.getText());
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String usuario = resultSet.getString("usuario");
                int idMensaje = resultSet.getInt("id_mensaje");
                String mensaje = resultSet.getString("mensaje");
                String fecha = resultSet.getString("fecha");
                tableModel.addRow(new Object[]{usuario, idMensaje, mensaje, fecha});
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviarButton) {
            enviarMensaje();
        } else if (e.getSource() == searchButton) {
            updateTable();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (textField.isFocusOwner()) {
                enviarMensaje();
            } else if (dateTextField.isFocusOwner()) {
                updateTable();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Enviar1());
    }
}
