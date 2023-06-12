/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

/**
 *
 * @author jhony
 */
public class Operacion {
    private int Tipo;       //1 Escribir  2 Leer    //3 Asignar 
    private String Instruccion;
    
    public Operacion(int Tipo, String Instruccion) {
        this.Tipo = Tipo;
        this.Instruccion = Instruccion;
    }


    public int getTipo() {
        return Tipo;
    }

    public String getInstruccion() {
        return Instruccion;
    }
    
}
