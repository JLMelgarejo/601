package classnotfoundexceptionexample;
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            // Intentamos cargar una clase que no existe
            Class<?> clazz = Class.forName("com.example.NonExistentClass");

            System.out.println("Clase cargada: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            // Capturamos la excepción ClassNotFoundException
            System.out.println("¡Se produjo una excepción de tipo ClassNotFoundException!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        }
    }
}
