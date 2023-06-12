/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;
import com.mycompany.project1.parser.Manejador;
/**
 *
 * @author jhony
 */
public class Operador {
    
    public static String Op(String x,String y,int tipo){
        String Resultado = "";
        boolean x1 = Manejador.isDouble(x);
        boolean x2 = Manejador.isInt(x);
        boolean y1 = Manejador.isDouble(y);
        boolean y2 = Manejador.isInt(y);
        
        if((x1|x2)&(y1|y2)){
            Double Number;
            switch(tipo){
                case 1:
                        Number = Double.valueOf(x) + Double.valueOf(y);
                        break;
                case 2:
                        Number = Double.valueOf(x) - Double.valueOf(y);
                        break;
                case 3:
                        Number = Double.valueOf(x) * Double.valueOf(y);
                        break;
                default:
                        Number = 1.5;
                        break;
            }
            Resultado = Number + "";
            return Resultado;
        }else return x+y;
    }
    
    public static String Convertir(String Numero){
        try {
            Double numerp = Double.parseDouble(Numero);
            int numero = numerp.intValue();
            return numero + "";
        } catch (NumberFormatException e) {
            return Numero;
        }
    }
    
}
