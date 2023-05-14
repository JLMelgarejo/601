package poo;
import javax.swing.JOptionPane;

public class MultiplosDeCincoYTres {
    public static void main(String[] args) {
        String num;
        int numr,dud,bub;
        num=JOptionPane.showInputDialog("Introduce un numero");
        numr=Integer.parseInt(num);
     dud=numr%5;
     bub=numr%3;
     if (bub==0 & dud==0){
       JOptionPane.showMessageDialog(null, "El numero es multiplo de tres y cinco");
     }
     else if(bub==0){
       JOptionPane.showMessageDialog(null, "El numero es multiplo de tres");  
     }
     else if (dud==0){
         JOptionPane.showMessageDialog(null, "El numero es multiplo de cinco");
     }
     else {
         JOptionPane.showMessageDialog(null, "El numero no es multiplo de tres ni cinco");
     }
 }
}
