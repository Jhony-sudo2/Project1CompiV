/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Funcion extends Operacion{
    private ArrayList<Operacion> Operaciones;
    private Tabla tablaFunciones;
    private int Tipo;
    public Funcion(Tabla tabla,ArrayList<Operacion> Operaciones,String Nombre){
        super(TipoOperacion.SWITCH,tabla);
        this.Operaciones = Operaciones;
    }
    
    @Override
    
    public void Ejecutar(){
        System.out.println("EJECUTANDO UNA FUNCION");
        if(Tipo == 1) DefinirFuncion();
        else EjecutarFuncion();
    }
    
    public void DefinirFuncion(){
    
    }
    
    public void EjecutarFuncion(){
    
    }
    
}
