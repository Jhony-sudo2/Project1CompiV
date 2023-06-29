/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import static com.mycompany.project1.parser.Manejador.isDouble;
import static com.mycompany.project1.parser.Manejador.isInt;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public abstract class Operacion {
    private  TipoOperacion Tipo;
    private Tabla tabla;
    private String Errores = "";
    private String Salida = "";
    private int Linea = 0;
    public Operacion(TipoOperacion Tipo,Tabla tabla,int Linea){
        this.Tipo = Tipo;
        this.tabla = tabla;
        this.Linea = Linea;
    }
    
    public void Ejecutar(){
        
    }
    
    public void EjecutarFunciones(ArrayList<Operacion> Operaciones){
        for (Operacion Operacione : Operaciones) {
            Operacione.Ejecutar();
            if(!Operacione.getSalida().isEmpty())Salida(Operacione.getSalida());
            if(!Operacione.getErrores().isEmpty()){
                Error(Operacione.getErrores());
                break;
            }
        }
    }
    
    public TipoOperacion getTipo(){
        return Tipo;
    }
    
    public boolean Existe(String Variable){
        return this.tabla.Buscar(Variable) == null;
    }
    
    public void setTabla(Tabla t){
        this.tabla = t;
    }
    
    public Tabla getTabla(){
        return tabla;
    }
    
    public void Error(String Error){
        Errores+=Error;
        Errores += " Linea: " + Linea;
    }
    public void Salida(String salida){
        if(Tipo == TipoOperacion.ESCRIBIR | Tipo == TipoOperacion.SALIDA)
        Salida = salida + "\n";
        else Salida += salida;
    }
    
    public String getErrores(){
        return Errores;
    }
    
    public String getSalida(){
        return Salida;
    }

    public void setTipo(TipoOperacion Tipo) {
        this.Tipo = Tipo;
    }
    
    public int getTipoDato(String V){
        int tipo=-1;
        if(isInt(V)) return 1;
        else if(isDouble(V)) return 2;
        else{
            if(Existe(V)) return 3;
            else {
                Variable tmp = tabla.Buscar(V);
                if(tmp!= null) return tmp.getTipo();
            } 
            
        }
        return 4;
    }
    
    public void setSalida(String t){
        Salida = t;
    }
    
    public void AsignarNuevaTabla(ArrayList<Operacion> Op,Tabla tmp){
        for (Operacion operacion : Op) {
            operacion.setTabla(tmp);
        }
    }
    
    public int getLinea(){
        return Linea;
    }
    
    
}
