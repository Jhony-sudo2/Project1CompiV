/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Casos {
    private final String Valor;
    private  Operacion Operacion;
    private  ArrayList<Operacion> Operaciones;
    
    /*
    public Casos(String Valor,Operacion Operacion) {
        this.Valor = Valor;
        this.Operacion = Operacion;
    }*/
    
    public Casos(String Valor, ArrayList<Operacion> Operaciones){
        this.Valor = Valor;
        this.Operaciones = Operaciones;
    }

    public String getValor() {
        return Valor;
    }

    public Operacion getOperacion() {
        return Operacion;
    }
    
    public ArrayList<Operacion> getOperaciones(){
        return Operaciones;
    }
    
    
    
    
}
