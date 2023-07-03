package nullpointerexceptionexample;
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String str = null; // Asignamos null a una variable de tipo String

            // Intentamos acceder a un método de la variable nula
            int length = str.length();

            System.out.println("La longitud de la cadena es: " + length);
        } catch (NullPointerException e) {
            // Capturamos la excepción NullPointerException
            System.out.println("¡Se produjo una excepción de tipo NullPointerException!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        }
    }
}
