package excepcion_2;

import javax.swing.JOptionPane;

public class Excepcion_2 {
    public static void main(String[] args) {
        int x, y;
        try {
            x=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Numero 1", "Solicito Datos", 3));
            y=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Numero 2","Solicito Datos", 3));
            JOptionPane.showMessageDialog(null, "La division de "+x+ "/"+y+"es"+(x/y),"Mostrando Resultado",1);
        } catch (NumberFormatException n) {
            System.out.println(n.getMessage()+"No es numero ENTERO");
        }
        catch(ArithmeticException e){
            System.out.println("No es posible dividir entre cero");
        }
    }
    
}
 