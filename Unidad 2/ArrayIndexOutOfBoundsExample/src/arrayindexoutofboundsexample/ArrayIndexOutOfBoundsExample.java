package arrayindexoutofboundsexample;
public class ArrayIndexOutOfBoundsExample {
    public static void main(String[] args) {
        try {
            int[] numbers = { 1, 2, 3 };
            int index = 5; // Acceso a un índice fuera del rango del arreglo

            // Intentamos acceder al elemento en el índice especificado
            int value = numbers[index];
            System.out.println("El valor en el índice " + index + " es: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Capturamos la excepción ArrayIndexOutOfBoundsException
            System.out.println("¡Se produjo una excepción!");
            System.out.println("Mensaje de excepción: " + e.getMessage());
        }
    }
}
