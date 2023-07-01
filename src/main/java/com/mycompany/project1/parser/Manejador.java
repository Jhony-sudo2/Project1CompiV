/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.parser;

import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import java.util.ArrayList;
import com.mycompany.project1.operaciones.Operacion;
/**
 *
 * @author jhony
 */
public class Manejador {
    private Tabla tabla;
    private String Salida = "";
    private String Errores = "";
    
    
    public Manejador(Tabla tabla) {
        this.tabla = tabla;
    }
    
    public Manejador(){
    
    }
    
    public void EjecutarSalidas(ArrayList<Operacion> T){
        for (Operacion operacion : T) {
            operacion.Ejecutar();
            if(!operacion.getSalida().isEmpty()) Salida += operacion.getSalida();
            if(!operacion.getErrores().isEmpty()) {
                Errores += operacion.getErrores();
                break;
            }  
        }
    }
    public boolean VerificarExistencia(String Var1){
        return tabla.Buscar(Var1) == null;
    }
    
    public int Condicion(String valor1,String valor2,int tipo){
        if(((isInt(valor2) | isDouble(valor2))) && (isInt(valor1) | isDouble(valor1))){
            if(Comparador(valor1,valor2,tipo)) return 1;
            else return 2;
        }else if((!isInt(valor1) & !isDouble(valor1)) & (!isInt(valor2) & !isDouble(valor2))){   
            Variable x = tabla.Buscar(valor1);
            Variable y = tabla.Buscar(valor2);
            if(x != null & y!=null){
                int tipo1 = x.getTipo();
                int tipo2 = y.getTipo();
                if(tipo1 == tipo2){
                    if(Comparador(x.getValor(),y.getValor(),tipo))return 1;
                    else return 2;
                }else return 0;
            }else return 0;
        }else if(!isInt(valor1) & !isDouble(valor1)){
            Variable x = tabla.Buscar(valor1);
            if(x != null){
                if(Comparador(x.getValor(),valor2,tipo)) return 1;
                else return 2;
            }else return 0;
        }else{
            Variable y = tabla.Buscar(valor2);
            if(y != null){
                if(Comparador(valor1,y.getValor(),tipo)) return 1;
                else return 2;
            }else return 0;
        }
    }
    
    public boolean Comparador(String t1,String t2,int tipo){
        Double x  = Double.valueOf(t1);
        Double y = Double.valueOf(t2);
        return switch (tipo) {
            case 1 -> x>y;
            case 2 -> x<y;
            case 3 -> x.equals(y);
            case 4 -> x>=y;
            case 5 -> x<=y;
            case 6 -> !x.equals(y);
            default -> false;
        };
    }
    
    
    public int getTipo(String Var1){
        Variable tmp = tabla.Buscar(Var1);
        return tmp.getTipo();
    }
    
    public static boolean Comparar(int Tipo,String Valor){
        return switch (Tipo) {
            case 1 -> isInt(Valor);
                case 2 -> isDouble(Valor);
            case 3 -> isString(Valor);
            default -> false;
        };
    }
    
    public static boolean isInt(String Value){
        try {
            Double numerp = Double.parseDouble(Value);
            int numero = numerp.intValue();
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public  static boolean isString(String Value){
        return true;
    }
    
    
    public  static boolean isDouble(String Value){
        try {
            double numero = Double.parseDouble(Value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public int getTipoDato(String V){
        int tipo=-1;
        if(isInt(V)) return 1;
        else if(isDouble(V)) return 2;
        else if(isString(V)){
            if(VerificarExistencia(V)) return 3;
            else {
                Variable tmp = tabla.Buscar(V);
                if(tmp!= null) return tmp.getTipo();
            } 
            
        }
        return 4;
    }  
    public String getMensaje(){
        if(Errores.isEmpty())return Salida;
        else return Errores;
    }
    
    public void Error(String Mensaje){
        Errores+=Mensaje;
    }
    
    
}
