package excepciones_1_programa_que_introduce_un_numero_entero;
import javax.swing.JOptionPane;
public class Excepciones_1_programa_que_introduce_un_numero_entero {
    public static void main(String[] args) {
        int x;
                int y;
        try{
        x=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero 1", "Solicita Datos",3));
    }catch(NumberFormatException n){
            System.out.println(n.getMessage()+"No es numero entero");
    }
    }
    
}
