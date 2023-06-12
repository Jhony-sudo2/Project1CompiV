/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.tablasimbolos;

import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Tabla {
    private ArrayList<Variable> Variables = new ArrayList<Variable>();
    
    public void Add(String Nombre, int Tipo, String Valor){
        Variables.add(new Variable(Nombre,Tipo,Valor));
    }
    
    public void Add(String Nombre,int Tipo){
        Variables.add(new Variable(Nombre,Tipo));
    }
    
    public Variable Buscar(String T){
        for (int i = 0; i < Variables.size(); i++) {
            Variable tmp = Variables.get(i);
            if(tmp.getNombre().equals(T))
                return tmp;
        }
        return null;
    }
    
    public void Actualizar(String Valor,String Var){
        Variable tmp = Buscar(Var);
        tmp.setValor(Valor);
    }
    
    
}
