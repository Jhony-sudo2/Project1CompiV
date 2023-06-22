/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.tablasimbolos.Tabla;

/**
 *
 * @author jhony
 */
public abstract class Operacion {
    private  TipoOperacion Tipo;
    private Tabla tabla;
    private String Errores = "";
    private String Salida = "";
    
    public Operacion(TipoOperacion Tipo,Tabla tabla){
        this.Tipo = Tipo;
        this.tabla = tabla;
    }
    
    public void Ejecutar(){
        
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
    
    
    
}
