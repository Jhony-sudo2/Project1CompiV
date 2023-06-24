/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.tablasimbolos;

import com.mycompany.project1.operaciones.Operacion;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class TablaFuncion extends Tabla{
    private ArrayList<Funcion>Funciones=new ArrayList<>();
    
    public void Add(String Nombre,int Retorno,ArrayList<Operacion> Operaciones,String ValorRetorno,ArrayList<Variable> Parametros){
        Funciones.add(new Funcion(Nombre,ValorRetorno,Parametros,Retorno,Operaciones));
    }
    
    public Funcion BuscarF(String Nombre){
        for (Funcion Funcione : Funciones) {
            if(Funcione.getNombre().equals(Nombre))return Funcione;
        }
        return null;
    }
}
