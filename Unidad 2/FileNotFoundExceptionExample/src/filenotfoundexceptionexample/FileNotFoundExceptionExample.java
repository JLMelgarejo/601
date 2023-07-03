package filenotfoundexceptionexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // Intentamos abrir un archivo que no existe
            reader = new BufferedReader(new FileReader("archivo.txt"));
            String line;

            // Leemos el archivo línea por línea
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            // Capturamos la excepción FileNotFoundException
            System.out.println("¡Se produjo una excepción de tipo FileNotFoundException!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        } catch (IOException e) {
            // Capturamos otras excepciones de tipo IOException
            System.out.println("¡Se produjo una excepción de tipo IOException!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        } finally {
            try {
                // Cerramos el BufferedReader en el bloque finally
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
