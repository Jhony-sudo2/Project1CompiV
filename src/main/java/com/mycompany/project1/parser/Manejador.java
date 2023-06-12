/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.parser;

import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import com.mycompany.project1.ui.Leer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author jhony
 */
public class Manejador {
    private Tabla tabla;
    private String Salida = "";
    
    
    public Manejador(Tabla tabla) {
        this.tabla = tabla;
    }
    
    public boolean TIpo(String Var1,String Var2){
        Variable tmp = tabla.Buscar(Var1);
        Variable tmp2 = tabla.Buscar(Var2);
        if(tmp != null & tmp2 !=null){
            int Tipo1 = tmp.getTipo();
            int Tipo2 = tmp2.getTipo();
            if(Tipo1 == Tipo2)return true;
            else return false;
        }else return false;
        
    }
    
    public void Actualizar(String Nombre,String Valor){
        if(!VerificarExistencia(Nombre)){
            Variable tmp = tabla.Buscar(Nombre);
            int TipoV = tmp.getTipo();
            if(Comparar(TipoV,Valor)){
                tabla.Actualizar(Valor, Nombre);
                System.out.println("VARIABLE: " + Nombre + " actualizada a: " + Valor);
            }else{
                ReportarError();
            }
        }
        
    }
    
    public void Asignacion(String Var,String Valor,int Tipo){
        if(VerificarExistencia(Var)){
            if(Valor == null){
                tabla.Add(Var, Tipo);
                System.out.println("VARIABLE: " + Var +" creada tipo: " + Tipo);
            }
            else if(Comparar(Tipo,Valor)){
                tabla.Add(Var, Tipo, Valor);
                System.out.println("VARIABLE: " + Var + " creada con valor: " + Valor);
            }else{
                
            }
        }else ReportarError();
        
    }
    
    public void ReportarError(){
        
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
    
    public void Leer(String Variable){
       java.util.Scanner n = new java.util.Scanner(System.in);
       String Valor = JOptionPane.showInputDialog("Variable:" + Variable);
       Actualizar(Variable,Valor);
    }
    
    
    public void Operacion(int Opcion,String T){
        if(Opcion == 2) Escribir(T);
        else if(Opcion == 1)Leer(T);
         
    }
    
    public void Escribir(String Mensaje){
        Variable tmp = tabla.Buscar(Mensaje);
        if(tmp == null){
            Salida += Mensaje + "\n";
        } else{
            Salida += tmp.getValor() + "\n"; 
        }
    }
    
    public boolean Comparador(String t1,String t2,int tipo){
        Double x  = Double.valueOf(t1);
        Double y = Double.valueOf(t2);
        return switch (tipo) {
            case 1 -> x>y;
            case 2 -> x<y;
            case 3 -> x==y;
            case 4 -> x>=y;
            case 5 -> x<=y;
            case 6 -> x!=y;
            default -> false;
        };
    }
    
    
    public int getTipo(String Var1){
        Variable tmp = tabla.Buscar(Var1);
        return tmp.getTipo();
    }
    
    public boolean Comparar(int Tipo,String Valor){
        return switch (Tipo) {
            case 1 -> isInt(Valor);
            case 2 -> isDouble(Valor);
            case 3 -> isString(Valor);
            default -> false;
        };
    }
    
    public  boolean isInt(String Value){
        try {
            Double numerp = Double.parseDouble(Value);
            int numero = numerp.intValue();
            return true;
        } catch (NumberFormatException e) {
            System.out.println("El String no representa un número entero válido.");
            return false;
        }
    }
    
    public  boolean isString(String Value){
        return true;
    }
    
    
    public  boolean isDouble(String Value){
        try {
            double numero = Double.parseDouble(Value);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("El String no representa un número double válido.");
            return false;
        }
    }
    
    public String getMensaje(){
        return this.Salida;
    }
    
    
}