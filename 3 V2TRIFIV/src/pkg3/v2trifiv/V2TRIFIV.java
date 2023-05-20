package pkg3.v2trifiv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V2TRIFIV {
    public static void main(String[] args) throws IOException {
                //Declaracion de variables
        BufferedReader bufEntrada=new BufferedReader(new InputStreamReader(System.in));
        int numero;
        int mult3;
        int mult5;
        //Entrada de datos
        System.out.println("Dame el numero");
        numero=Integer.parseInt(bufEntrada.readLine());
//Procesar datos
        mult3=numero%3;
        mult5=numero%5;
 //salida de datos
 if(mult3==0 && mult5==0){
     System.out.println("TRIFIV");
 }
 else if(mult3==0){
     System.out.println("TRI");
 }else if (mult5==0){
     System.out.println("Fiv");
 }
    }
    
}
