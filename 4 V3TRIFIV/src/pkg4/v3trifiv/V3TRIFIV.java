package pkg4.v3trifiv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class V3TRIFIV {
    public static void main(String[] args) throws IOException {
         //Declaracion de variables
        BufferedReader bufEntrada=new BufferedReader(new InputStreamReader(System.in));
        int num;
 //Entrada de datos
        System.out.println("Dame el numero");
        num=Integer.parseInt(bufEntrada.readLine());
        //salida de datos 
        System.out.println( retornaMultiplo(num));
    }    
    public static String retornaMultiplo (int num){
        int mult3;
        int mult5;
        //procesar datos
         mult3=num%3;
        mult5=num%5;
        //salida de datos
        if(mult3==0 && mult5==0){
     return("TRIFIV");
 }
 else if(mult3==0){
     return("TRI");
 }else if (mult5==0){
     return("Fiv");
 }
        return "Ningun valor";
    } 
}
