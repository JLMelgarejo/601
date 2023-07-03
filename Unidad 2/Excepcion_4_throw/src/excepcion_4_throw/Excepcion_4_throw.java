/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepcion_4_throw;

/**
 *
 * @author melga
 */
public class Excepcion_4_throw {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int division=miMetodo(10,0);
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println("Expresion aritmetica arrojada");
        }
    }
    public static int miMetodo(int a, int b) throws ArithmeticException{
    int c=a/b;
    return c;
    }
    
}
