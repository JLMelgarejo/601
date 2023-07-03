package classcastexceptionexample;
public class ClassCastExceptionExample {
    public static void main(String[] args) {
        try {
            Object obj = "Hola"; // Creamos un objeto de tipo String
            Integer number = (Integer) obj; // Intentamos convertirlo a Integer

            System.out.println("El número es: " + number);
        } catch (ClassCastException e) {
            // Capturamos la excepción ClassCastException
            System.out.println("¡Se produjo una excepción de tipo ClassCastException!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        }
    }
}
